package nghia.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableScheduling
public class NghiaAmqpProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NghiaAmqpProducerApplication.class, args);
    }
}
