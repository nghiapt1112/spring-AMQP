package nghia.amqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NghiaJmsActiveMQApplication {

    public static void main(String[] args) {
        SpringApplication.run(NghiaJmsActiveMQApplication.class, args);
    }
}
