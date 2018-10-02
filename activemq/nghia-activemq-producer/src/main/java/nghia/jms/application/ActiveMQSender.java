package nghia.jms.application;

import nghia.jms.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
@RequestMapping("/activeMQ")
public class ActiveMQSender {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private JmsTemplate jmsTemplate;


    @GetMapping(value = "/{quantityMsg}")
    public void sendMsg(@PathVariable Integer quantityMsg) {
        if (quantityMsg <= 0) {
            quantityMsg = 20;
        }


        IntStream.range(1, quantityMsg)
                .forEach(el -> {
                    String destination = "helloworld.q";
                    User message = User.testUser();
//                    String message = "Hello Spring JMS ActiveMQ!";
                    LOGGER.info("sending message='{}' to destination='{}'", message, destination);
                    jmsTemplate.convertAndSend("helloworld.q", message);
                    LOGGER.info(" [x] Sent '" + message + "'" + el);
                });

    }


}
