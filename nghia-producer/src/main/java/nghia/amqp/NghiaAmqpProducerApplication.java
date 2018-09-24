package nghia.amqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NghiaAmqpProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NghiaAmqpProducerApplication.class, args);
    }
}
