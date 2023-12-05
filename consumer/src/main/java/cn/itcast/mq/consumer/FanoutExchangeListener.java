package cn.itcast.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutExchangeListener {

    @RabbitListener(queues = "fanout.queue1")
    public void consumer1(String message) {
        System.out.println("消费者1接收到队列fanout.queue1的消息：" + message);
    }

    @RabbitListener(queues = "fanout.queue2")
    public void consumer2(String message) {
        System.out.println("消费者2接收到队列fanout.queue2的消息：" + message);
    }

}
