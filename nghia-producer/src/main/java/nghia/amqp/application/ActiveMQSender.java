package nghia.amqp.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Topic;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/activeMQ")
public class ActiveMQSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitTopicSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;


    @GetMapping(value = "/{messageNumbers}")
    public void send(@PathVariable Integer messageNumbers) {
        if (messageNumbers <= 0) {
            messageNumbers = 20;
        }


        IntStream.range(1, messageNumbers)
                .forEach(el -> {
                    String destination = "helloworld.q";
                    String message = "Hello Spring JMS ActiveMQ!";
                    LOGGER.info("sending message='{}' to destination='{}'", message, destination);
                    jmsTemplate.convertAndSend("helloworld.q", message);
                    LOGGER.info(" [x] Sent '" + message + "'" + el);
                });

    }


}
