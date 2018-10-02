//package nghia.amqp.dead.letter.config;
//
//import org.springframework.amqp.core.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class DeadLetterProducer{
//
//    public static String EXCHANGE_NAME = "DeadLetter.Exchange";
//    public static String QUEUE_NAME = "DeadLetter.Queue";
//
//    public Queue createQueue() {
//        //the deadletter queue arguement must be provided to allow rabbitmq to treat it as such.
//        //https://www.rabbitmq.com/dlx.html
//        Map<String, Object> args = new HashMap<>();
//        args.put("x-dead-letter-exchange", QUEUE_NAME);
//
//        return new Queue(QUEUE_NAME, false, false, false, args);
//    }
//
//    @Autowired
//    private AmqpAdmin amqpAdmin;
//
//
//    @PostConstruct
//    public void postConstruct() {
//        bind();
//    }
//
////    public Queue createQueue() {
////        return new Queue(QUEUE_NAME);
////    }
//
//    public String getRoutingKey() {
//        return QUEUE_NAME;
//    }
//
//    public void bind() {
//        //create the exchange
//        DirectExchange exchange = new DirectExchange(EXCHANGE_NAME);
//        amqpAdmin.declareExchange(exchange);
//
//        //create the queue
//        Queue queue = createQueue();
//        amqpAdmin.declareQueue(queue);
//
//        //create the binding between the two
//        Binding binding = BindingBuilder.bind(queue).to(exchange).with(getRoutingKey());
//        amqpAdmin.declareBinding(binding);
//    }
//
////    public <T> void send(T message) {
////        rabbitTemplate.convertAndSend(getExchangeName(), getRoutingKey(), message);
////    }
//
//}
