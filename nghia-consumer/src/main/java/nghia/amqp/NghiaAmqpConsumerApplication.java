package nghia.amqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NghiaAmqpConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NghiaAmqpConsumerApplication.class, args);
	}
}
