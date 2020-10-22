package online.ltsoft.cnrdsreport.provider;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class SendMessageController {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/patientinfoMessage")
    public String patientinfoMessage() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: patientinfoMessage";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> messageMap = new HashMap<>();
        messageMap.put("messageId", messageId);
        messageMap.put("messageData", messageData);
        messageMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("reportExchange", "report.patientinfo", messageMap);
        return "ok";
    }

    @GetMapping("/resultsMessage")
    public String resultsMessage() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: resultsMessage";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> messageMap = new HashMap<>();
        messageMap.put("messageId", messageId);
        messageMap.put("messageData", messageData);
        messageMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("reportExchange", "report.results", messageMap);
        return "ok";
    }
}
