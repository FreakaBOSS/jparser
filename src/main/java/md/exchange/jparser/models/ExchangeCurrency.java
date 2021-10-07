package md.exchange.jparser.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExchangeCurrency {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String currencyAbbr;

  private Double currencyRate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCurrencyAbbr() {
    return currencyAbbr;
  }

  public void setCurrencyAbbr(String currencyAbbr) {
    this.currencyAbbr = currencyAbbr;
  }

  public Double getCurrencyRate() {
    return currencyRate;
  }

  public void setCurrencyRate(Double currencyRate) {
    this.currencyRate = currencyRate;
  }
}
