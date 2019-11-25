package cn.xiuminglee;

import cn.xiuminglee.producer.MessageProductSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author Xiuming Lee
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StreamProducerTest {

    @Autowired
    private MessageProductSender sender;

    @Test
    public void testSend() {
        for (int i = 0; i <5 ; i++) {
            sender.send("0");
            sender.send("1");
            sender.send("2");
        }
    }
}
