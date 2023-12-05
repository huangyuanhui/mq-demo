package cn.itcast.mq.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class FanoutExchangeTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage() {
        String exchangeName = "hyh.fanout";
        String message = "我好像舔你的逼啊！I really want to lick you pussy!";
        rabbitTemplate.convertAndSend(exchangeName, "", message);
    }
}
