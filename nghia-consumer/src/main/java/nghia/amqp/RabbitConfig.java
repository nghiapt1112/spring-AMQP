package nghia.amqp;

import nghia.amqp.consumer.Receiver;
import nghia.amqp.consumer.UserReceiver;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    private static final String DEFAULT_EX = "tut.topic";
    private static final String USER_WORKER = "tut.user.topic";

    @Bean
    public TopicExchange topic() {
        return new TopicExchange(DEFAULT_EX);
    }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }


    @Bean
    public TopicExchange userTopic() {
        return new TopicExchange(USER_WORKER);
    }

    @Bean
    public UserReceiver userReceiver() {
        return new UserReceiver();
    }

}
