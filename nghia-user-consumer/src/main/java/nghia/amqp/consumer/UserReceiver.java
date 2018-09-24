package nghia.amqp.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

public class UserReceiver {


    @RabbitListener(queues = "user_queue1")
    public void receive1(String message) throws InterruptedException {
        receive(message, 1);

    }


    public void receive(String message, int receiver) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("====user service \t[x] user_queue1: '" + message + "'");
        doWork(message);
        watch.stop();
        System.out.println("====user service \t[x] Done in '" + watch.getTotalTimeSeconds() + "s");
    }


    private void doWork(String in) throws InterruptedException {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
    }
}
