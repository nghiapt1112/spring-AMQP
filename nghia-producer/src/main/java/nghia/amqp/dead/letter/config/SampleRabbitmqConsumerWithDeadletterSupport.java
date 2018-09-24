//package nghia.amqp.dead.letter.config;
//
//import org.aopalliance.aop.Advice;
//import org.springframework.amqp.core.AmqpAdmin;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.core.MessageListener;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.retry.interceptor.RetryOperationsInterceptor;
//
//public class SampleRabbitmqConsumerWithDeadletterSupport implements MessageListener {
//
//    protected SimpleMessageListenerContainer simpleMessageListenerContainer;
//    @Autowired
//    private ConnectionFactory connectionFactory;
//    @Autowired
//    private AmqpAdmin amqpAdmin;
//    /* Autowire in the RetryOperationsInteceptor that is setup in the configuration so that it can be attached to the
//     * SimpleMessageListenerContainer. Now when the container throws an expception, the new retry operations for the
//     * deadletter queue will be invoked.
//     */
//    @Autowired
//    private RetryOperationsInterceptor retryOperationsInterceptor;
//
//    public SimpleMessageListenerContainer createSimpleMessageListenerContainer() {
//        amqpAdmin.declareQueue(new Queue("yourQueueName"));
//
//        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer(connectionFactory);
//
//        //attach the retryOperationsInterceptor as part of the adviceChain
//        simpleMessageListenerContainer.setAdviceChain(new Advice[]{retryOperationsInterceptor});
//
//        simpleMessageListenerContainer.setQueueNames("yourQueueName");
//        simpleMessageListenerContainer.setMessageListener(this);
//
//        return simpleMessageListenerContainer;
//    }
//
//    @Override
//    public void onMessage(Message message) {
//        //this is where you consume the message
////      consumeMessage(message);
//    }
//
//
//}