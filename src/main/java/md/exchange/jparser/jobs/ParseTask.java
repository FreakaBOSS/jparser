package md.exchange.jparser.jobs;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import md.exchange.jparser.models.Exchange;
import md.exchange.jparser.models.ExchangeCurrency;
import md.exchange.jparser.services.ExchangeService;

@Component
public class ParseTask {

  private final List<String> classNames = Arrays.asList("USD", "EUR", "RUB", "RON", "UAH");

  @Autowired
  ExchangeService exchangeService;

  @Scheduled(fixedDelay = 10000)
  public void parseNewExchange() {
    String url = "https://www.curs.md/en/curs_valutar_banci";
    try {
      Document document = Jsoup.connect(url)
          .userAgent("Mozilla")
          .timeout(5000)
          .referrer("https://www.google.com/")
          .get();
      Elements elements = document.getElementsByClass("bank_name");
      for (Element element : elements) {
        Exchange exchange = new Exchange();
        if (!element.getElementsByClass("badge-bank").isEmpty()) {
          exchange.setBankName(element.getElementsByTag("a").text());
          List<ExchangeCurrency> exchangeCurrencies = new ArrayList<>();
          for (String className : classNames) {
            setCurrency(element, exchangeCurrencies, className);
          }
          exchange.setExchangeCurrencies(exchangeCurrencies);
          exchangeService.save(exchange);
        }
      }
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }

  private void setCurrency(Element element, List<ExchangeCurrency> exchangeCurrencies, String className) {
    for (Object o : Arrays.stream(((Element) Objects.requireNonNull(element.parentNode())).getElementsByClass("column-" + className).text().split(" ")).toArray()) {
      ExchangeCurrency exchangeCurrency = new ExchangeCurrency();
      exchangeCurrency.setCurrencyAbbr(className);
      String strRate = o.toString();
      exchangeCurrency.setCurrencyRate(Double.parseDouble(strRate.equals("-") ? "0" : strRate));
      exchangeCurrencies.add(exchangeCurrency);
    }
  }
}
