package cn.itcast.mq.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectExchangeListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "hyh.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "blue"}
    ))
    public void consumer1(String message) {
        System.out.println("消费者1接收到队列direct.queue1的消息：" + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "hyh.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "yellow"}
    ))
    public void consumer2(String message) {
        System.out.println("消费者2接收到队列direct.queue2的消息：" + message);
    }
}
