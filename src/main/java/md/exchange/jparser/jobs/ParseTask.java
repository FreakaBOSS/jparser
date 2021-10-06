package md.exchange.jparser.jobs;

import md.exchange.jparser.models.Exchange;
import md.exchange.jparser.services.ExchangeService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ParseTask {

    @Autowired
    ExchangeService exchangeService;

    @Scheduled(fixedDelay = 1000)
    public void parseNewExchange() {
        String url = "https://www.curs.md/en/curs_valutar_banci";
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla")
                    .timeout(5000)
                    .referrer("https://www.google.com/")
                    .get();
            Elements elements = document.getElementsByClass("bank_name");
            for (Element element: elements) {
                Exchange exchange = new Exchange();
                exchange.setBankName(element.ownText());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
