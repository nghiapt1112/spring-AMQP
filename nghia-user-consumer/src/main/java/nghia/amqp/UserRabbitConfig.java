package nghia.amqp;

import nghia.amqp.consumer.UserReceiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

@Configuration
public class UserRabbitConfig {

    private static final String USER_WORKER = "tut.user.topic";

    @Bean
    public TopicExchange userTopic() {
        return new TopicExchange(USER_WORKER);
    }

    @Bean
    public UserReceiver userReceiver() {
        return new UserReceiver();
    }

    @Bean
    public Queue autoDeleteQueue1() {
        return new Queue("user_queue1");
    }

    @Bean
    public Binding binding1a(TopicExchange topic, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1)
                .to(topic)
                .with("user.*");
    }

    public MappingJackson2MessageConverter messageConverter() {
        return null;
    }

    public SimpleRabbitListenerContainerFactory factory() {
        SimpleRabbitListenerContainerFactory fac = new SimpleRabbitListenerContainerFactory();
        fac.setMessageConverter(null);
        return fac;
    }
}
