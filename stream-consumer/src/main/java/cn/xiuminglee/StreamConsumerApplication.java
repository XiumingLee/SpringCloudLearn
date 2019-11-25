package cn.xiuminglee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @Author Xiuming Lee
 * @Description
 */
@SpringBootApplication
@EnableBinding(Sink.class)
public class StreamConsumerApplication {

    // 监听 binding 为 Sink.INPUT 的消息
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("监听收到:" + message.getPayload());
    }

    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerApplication.class);
    }
}
