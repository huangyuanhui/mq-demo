package cn.itcast.mq.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicExchangeListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue1"),
            exchange = @Exchange(value = "hyh.topic", type = ExchangeTypes.TOPIC),
            key = {"#.news"}
    ))
    public void consumer1(String msg) {
        System.out.println("消费者1接收到队列top.queue1的消息：" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue2"),
            exchange = @Exchange(value = "hyh.topic", type = ExchangeTypes.TOPIC),
            key = {"china.#"}
    ))
    public void consumer2(String msg) {
        System.out.println("消费者1接收到队列top.queue1的消息：" + msg);
    }
}
