package cn.itcast.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BasicQueueListener {

    /*@RabbitListener(queues = "simple.queue")
    public void consumer(String msg) {
        System.out.println("消费者接收到simple.queue的消息：" + msg);
    }*/

    @RabbitListener(queues = "object.queue")
    public void consumer(Map<String, Object> message) {
        System.out.println("消费者接收到simple.queue的消息：" + message);
    }
}
