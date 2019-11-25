package cn.xiuminglee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @Author Xiuming Lee
 * @Description
 */
@SpringBootApplication
@EnableBinding(Source.class)
public class StreamProducerApplication implements CommandLineRunner {
    @Autowired
    @Qualifier("output")
    MessageChannel output;

    @Override
    public void run(String... strings) throws Exception { //发送MQ消息
        output.send(MessageBuilder.withPayload("hello world Xiuming").build());
    }
    public static void main(String[] args) {
        SpringApplication.run(StreamProducerApplication.class);
    }
}
