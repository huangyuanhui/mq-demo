package cn.itcast.mq.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * junit5以后之后，测试类只需要加@SpringBootTest，不需要再加@RunWith
 * 因为SpringBootTest已经整合了RunWith
 */
@SpringBootTest
public class BasicQueueTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage() {
        String queueName = "simple.queue";
        String message = "我好像舔你的逼啊！I really want to lick you pussy!";
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
