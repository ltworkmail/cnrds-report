package online.ltsoft.common.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTopicConfig {
    public final static String PATIENTINFO = "report.patientinfo";
    public final static String RESULTS = "report.results";

    @Bean
    TopicExchange exchange() {
        /*交换机名：topicExchange*/
        return new TopicExchange("reportExchange");
    }

    @Bean
    public Queue firstQueue() {
        /*队列名：TestDirectQueue
         * durable：是否持久化,默认是false；持久化队列:会被存储在磁盘上,当消息代理重启时仍然存在
         * exclusive：是否只能被当前创建的连接使用,默认是false；而且当连接关闭后队列即被删除,此参考优先级高于durable
         * autoDelete：是否自动删除,默认是false；当没有生产者或者消费者使用此队列，该队列会自动删除
         * return new Queue("report.patientinfo",true,true,false)*/
        return new Queue(RabbitTopicConfig.PATIENTINFO, true);
    }

    @Bean
    public Queue secondQueue() {
        /*队列名：TestDirectQueue
         * durable：是否持久化,默认是false；持久化队列:会被存储在磁盘上,当消息代理重启时仍然存在
         * exclusive：是否只能被当前创建的连接使用,默认是false；而且当连接关闭后队列即被删除,此参考优先级高于durable
         * autoDelete：是否自动删除,默认是false；当没有生产者或者消费者使用此队列，该队列会自动删除
         * return new Queue("report.results",true,true,false)*/
        return new Queue(RabbitTopicConfig.RESULTS, true);
    }

    @Bean
    Binding bindingFirstExchange() {
        /*队列和交换机绑定：设置用于匹配键名report.patientinfo*/
        return BindingBuilder.bind(firstQueue()).to(exchange()).with(RabbitTopicConfig.PATIENTINFO);
    }

    @Bean
    Binding bindingSecondExchange() {
        /*队列和交换机绑定：设置用于匹配键名report.results*/
        return BindingBuilder.bind(secondQueue()).to(exchange()).with(RabbitTopicConfig.RESULTS);
    }
}
