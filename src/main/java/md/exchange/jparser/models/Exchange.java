package md.exchange.jparser.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bankName;

    private String currencyAbbr;

    private Double rate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCurrencyAbbr() {
        return currencyAbbr;
    }

    public void setCurrencyAbbr(String currencyAbbr) {
        this.currencyAbbr = currencyAbbr;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
