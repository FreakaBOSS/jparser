package md.exchange.jparser.services;

import md.exchange.jparser.models.Exchange;
import md.exchange.jparser.repositories.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService {
    @Autowired
    ExchangeRepository exchangeRepository;

    @Override
    public void save(Exchange exchange) {
        exchangeRepository.save(exchange);
    }

    @Override
    public List<Exchange> getAllExchanges() {
        return  exchangeRepository.findAll();
    }
}
