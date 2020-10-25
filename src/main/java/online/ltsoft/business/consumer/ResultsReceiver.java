package online.ltsoft.cnrdsreport.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
@RabbitListener(queues="report.results")
public class ResultsReceiver {
    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("ResultsReceiver消费者收到消息: " + testMessage.toString());
    }
}

