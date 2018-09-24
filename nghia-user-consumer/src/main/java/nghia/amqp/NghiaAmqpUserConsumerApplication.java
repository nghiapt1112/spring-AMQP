package nghia.amqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
//@EnableRabbit // for custom config
public class NghiaAmqpUserConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NghiaAmqpUserConsumerApplication.class, args);
    }
}
