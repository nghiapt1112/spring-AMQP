//package nghia.amqp.dead.letter.config;
//
//import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.retry.RepublishMessageRecoverer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.retry.backoff.ExponentialBackOffPolicy;
//import org.springframework.retry.interceptor.RetryOperationsInterceptor;
//import org.springframework.retry.policy.SimpleRetryPolicy;
//import org.springframework.retry.support.RetryTemplate;
//
///**
// * The main point of this Spring configuration is to demonstrate the retryTemplate and the deadLetterInteceptor that needs
// * to be coded to requeue messages on their appropriate queues until the retry threshold is exceeded and then
// * the message is placed on the deadletter queue.
// * The amqpConnectionFactory with deadletter retry support.
// * The retry template uses an ExponentialBackOffPolicy with some basic settings assumed.
// * The connection factory also assumes basic settings.
// */
//@Configuration
//public class SpringRabbitmqDeadletterConfiguration{
//
//    //Basic connectionFactory setup, there is no deadletter or retry specific settings here
//    @Bean
//    ConnectionFactory amqpConnectionFactory() {
//        CachingConnectionFactory connectionFactory = null;
//
//        connectionFactory = new CachingConnectionFactory("localhost");
//
//        connectionFactory.setUsername("guest");
//        connectionFactory.setPassword("guest");
//        connectionFactory.setChannelCacheSize(25);
//        connectionFactory.setCloseTimeout(30000);
//        connectionFactory.setConnectionCacheSize(1);
//        connectionFactory.setRequestedHeartBeat(0);
//
//        return connectionFactory;
//    }
//
//    /**
//     * Sets up the RetryTemplate, ExponentialBackOffPolicy with some basic settings, attaches that to the template
//     * as a SimpleRetryPolicy
//     *
//     * @return RetryTemplate
//     */
//    @Bean
//    public RetryTemplate retryTemplate() {
//        //create retryTemplate and attach the backoffPolicy
//        RetryTemplate retryTemplate = new RetryTemplate();
//        retryTemplate.setBackOffPolicy(exponentialBackOffPolicy());
//
//        //create a SimpleRetryPolicy and attach to the retryTemplate
//        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
//        retryTemplate.setRetryPolicy(retryPolicy);
//
//        return retryTemplate;
//    }
//
//    public ExponentialBackOffPolicy exponentialBackOffPolicy(){
//        //setup ExponentialBackOffPolicy
//        ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
//        backOffPolicy.setInitialInterval(1000);
//        backOffPolicy.setMultiplier(10.0);
//        backOffPolicy.setMaxInterval(30000);
//
//        return backOffPolicy;
//    }
//
//    /**
//     * Creates an interceptor that is can be attached to queues that will try to requeue a failed message a number of
//     * times and then it will place on the deadletter queue.
//     */
//    @Bean
//    RetryOperationsInterceptor deadLetterInterceptor() {
//
//        return RetryInterceptorBuilder.stateless().maxAttempts(5).recoverer(
//                new RepublishMessageRecoverer(rabbitTemplate(), DeadLetterProducer.EXCHANGE_NAME,
//                    DeadLetterProducer.QUEUE_NAME))
//                .backOffPolicy(exponentialBackOffPolicy()).build();
//    }
//
//    /**
//     * A message queue manager that applies a retry template
//     *
//     * @return RabbitTemplate
//     */
//    @Bean
//    public RabbitTemplate rabbitTemplate() {
//        RabbitTemplate messageQueueManager = new RabbitTemplate(amqpConnectionFactory());
//        messageQueueManager.setRetryTemplate(this.retryTemplate());
//        return messageQueueManager;
//    }
//
//}