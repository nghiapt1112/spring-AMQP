package nghia.amqp.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
@RequestMapping("/sendEvent")
public class Sender {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final String[] keys = {"quick.orange.rabbit", "lazy.orange.elephant", "quick.orange.fox",
            "lazy.brown.fox", "lazy.pink.rabbit", "quick.brown.fox", "user.test"};

    @Autowired
    private RabbitTemplate template;
    @Autowired
    private TopicExchange commonWorker;

    @Autowired
    private TopicExchange userWorker;

    private int index;
    private int count;

//    @Scheduled(initialDelay = 5000, fixedDelay = 10000)
    @GetMapping(value = "/{messageNumbers}")
    public void send(@PathVariable Integer messageNumbers) {
        if (messageNumbers <= 0) {
            messageNumbers = 20;
        }


        IntStream.range(1, messageNumbers)
                .forEach(el -> {
                    StringBuilder builder = new StringBuilder("Hello ");
                    if (this.index == 20) {
                        System.exit(-1);
                    }
                    if (++this.index == keys.length) {
                        this.index = 0;
                    }

                    String key = keys[this.index];
                    builder.append(key).append(' ');
                    builder.append(Integer.toString(++this.count));
                    String message = builder.toString();


                    // key: quick.brown.fox didn't implement queue for this routingKey
                    if (key.contains("user.test")) {
                        template.convertAndSend(userWorker.getName(), key, message);
                    } else {
                        template.convertAndSend(commonWorker.getName(), key, message);
                    }
                    LOGGER.info(" [x] Sent '" + message + "'");
                });

    }

}
