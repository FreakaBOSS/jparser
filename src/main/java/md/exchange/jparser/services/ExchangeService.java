package md.exchange.jparser.services;

import md.exchange.jparser.models.Exchange;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExchangeService {
    public void save(Exchange exchange);
    public List<Exchange> getAllExchanges();
}
