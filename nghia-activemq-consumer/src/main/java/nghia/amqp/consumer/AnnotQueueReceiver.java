package nghia.amqp.consumer;

import nghia.amqp.domain.User;
import nghia.amqp.exception.QueueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class AnnotQueueReceiver {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

//    @JmsListener(destination = "helloworld.q")
    public void receive(User message) {
        LOGGER.info("received message='{}'", message);
        latch.countDown();
    }


    @JmsListener(destination = "helloworld.exception")
    public void receiveException(@Payload Object data) {
        LOGGER.info("Received message: {}", data);

        throw new QueueException("Listener couldn't handle this message");
    }

    @JmsListener(destination = "helloworld.q")
    public void receive2(Message<Object> message) {
        LOGGER.info("Received message: {}", message);

        MessageHeaders header = message.getHeaders();
        Object payload = message.getPayload();
        throw  new QueueException("Listener couldn't handle this message");
    }
}


