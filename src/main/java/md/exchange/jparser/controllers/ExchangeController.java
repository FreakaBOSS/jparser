package md.exchange.jparser.controllers;

import md.exchange.jparser.models.Exchange;
import md.exchange.jparser.services.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExchangeController {

    @Autowired
    ExchangeService exchangeService;

    @GetMapping(value = "/exchanges")
    public List<Exchange> getAllExchanges() {
        return exchangeService.getAllExchanges();
    }
}
