package nghia.amqp;

import nghia.amqp.application.Sender;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.interceptor.RetryInterceptorBuilder;
import org.springframework.retry.interceptor.StatefulRetryOperationsInterceptor;

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

    @Bean
    public Sender sender() {
        return new Sender();
    }


}
