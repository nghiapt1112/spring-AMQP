package nghia.amqp;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReceiverConfig {

    @Bean
    public Queue autoDeleteQueue1() {
        return new Queue("orange_rabbit_queue");
    }

    @Bean
    public Queue autoDeleteQueue2() {
        return new Queue("lazy_queue");
    }

    @Bean
    public Binding binding1a(TopicExchange topic, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1)
                .to(topic)
                .with("*.orange.*");
    }

    @Bean
    public Binding binding1b(TopicExchange topic, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1)
                .to(topic)
                .with("*.*.rabbit");
    }


    @Bean
    public Binding binding2a(TopicExchange topic, Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2)
                .to(topic)
                .with("lazy.#");
    }
}


