package nghia.amqp.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class QueueReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueReceiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @JmsListener(destination = "${queue.helloworld}")
    public void receive(String message) {
        LOGGER.info("received message='{}'", message);
        latch.countDown();
    }

}


