package md.exchange.jparser.models;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bankName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ExchangeCurrency> exchangeCurrencies;

    @Basic
    private java.sql.Timestamp sqlTimestamp;


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

    public List<ExchangeCurrency> getExchangeCurrencies() {
        return exchangeCurrencies;
    }

    public void setExchangeCurrencies(List<ExchangeCurrency> exchangeCurrencies) {
        this.exchangeCurrencies = exchangeCurrencies;
    }
}
