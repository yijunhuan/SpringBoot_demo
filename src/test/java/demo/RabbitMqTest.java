package demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.MainApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MainApplication.class })
public class RabbitMqTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void sendMessage() {
        Map<String, Object> obj = new HashMap<>();
        obj.put("msg", "第一条数据");
        obj.put("code", "10");
        obj.put("data", "helloworld");

        rabbitTemplate.convertAndSend("exchange.direct", "huang", obj);
    }

    @Test
    public void reciveMessage() {
        Object obj = rabbitTemplate.receiveAndConvert("huang");
        System.out.println(obj.getClass());
        System.out.println(obj);
    }

}
