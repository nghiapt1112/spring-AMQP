package nghia.amqp;

import nghia.amqp.application.RabbitTopicSender;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public TopicExchange commonWorker() {
        return new TopicExchange("tut.topic");
    }

    @Bean
    public TopicExchange userWorker() {
        return new TopicExchange("tut.user.topic");
    }

}
