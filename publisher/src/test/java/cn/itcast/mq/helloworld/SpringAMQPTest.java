package cn.itcast.mq.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class SpringAMQPTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    void testSendObjectQueue() {
        Map<String, Object> msg = new HashMap<>();
        msg.put("name", "刘亦菲");
        msg.put("age", 38);
        rabbitTemplate.convertAndSend("object.queue", msg);
    }
}
