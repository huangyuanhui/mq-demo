package cn.itcast.mq.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class WorkQueueTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage() throws InterruptedException {
        String queueName = "simple.queue";
        String message = "我好像舔你的逼啊！I really want to lick you pussy!";
        // 循环发送50条消息
        for (int i = 1; i <= 50; i++) {
            rabbitTemplate.convertAndSend(queueName, message + "-" + i);
            Thread.sleep(20);
        }
    }
}
