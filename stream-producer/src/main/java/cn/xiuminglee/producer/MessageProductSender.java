package cn.xiuminglee.producer;


import cn.xiuminglee.channel.MyStreamChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @Author Xiuming Lee
 * @Description 发送消息，使用我们自定义的通道
 */
@Component
@EnableBinding(MyStreamChannel.class)
public class MessageProductSender {

    @Autowired
    @Qualifier(value="ming-output")
    private MessageChannel mingOutput;

    //发送消息
    public void send(Object obj) {
        mingOutput.send(MessageBuilder.withPayload(obj).build());
    }
}
