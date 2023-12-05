package cn.itcast.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class WorkQueueListener {

    @RabbitListener(queues = "simple.queue")
    public void consumer1(String message) throws InterruptedException {
        System.out.println("消费者1接收到消息：" + message + "，" + LocalTime.now());
        // 消费者1每秒处理50个消息
        Thread.sleep(20);
    }

    @RabbitListener(queues = "simple.queue")
    public void consumer2(String message) throws InterruptedException {
        System.err.println("消费者2接收到消息：" + message + "，" + LocalTime.now());
        // 消费者2每秒处理10个消息
        Thread.sleep(100);
    }
}
