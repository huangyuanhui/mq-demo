package cn.itcast.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    @Bean
    public FanoutExchange fanoutExchange() {
        // 声明FanoutExchange广播交换机：hyh.fanout
        return new FanoutExchange("hyh.fanout");
    }

    @Bean
    public Queue fanoutQueue1() {
        // 声明队列：fanout.queue1，注意方法名称就是bean的唯一ID
        return new Queue("fanout.queue1");
    }

    @Bean
    public Queue fanoutQueue2() {
        // 声明队列：fanout.queue1
        return new Queue("fanout.queue2");
    }

    @Bean
    public Binding fanoutBinding1(FanoutExchange fanoutExchange,
                                  Queue fanoutQueue1) {
        // 绑定队列fanoutQueue1到交换机fanoutExchange
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    @Bean
    public Binding fanoutBinding2(FanoutExchange fanoutExchange,
                                  Queue fanoutQueue2) {
        // 绑定队列fanoutQueue2到交换机fanoutExchange
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }
}
