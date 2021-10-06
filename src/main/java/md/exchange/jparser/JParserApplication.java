package md.exchange.jparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JParserApplication {

    public static void main(String[] args) {
        SpringApplication.run(JParserApplication.class, args);
    }

}
