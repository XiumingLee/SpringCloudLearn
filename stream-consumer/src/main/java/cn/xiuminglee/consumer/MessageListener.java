package cn.xiuminglee.consumer;


import cn.xiuminglee.channel.MyStreamChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @Author Xiuming Lee
 * @Description 监听自定义通道的信息
 */
@Component
@EnableBinding(MyStreamChannel.class)
public class MessageListener {
    //监听binding中的消息
    @StreamListener(MyStreamChannel.Ming_CHANNEL)
    public void input(String message) {
        System.out.println("获取到消息: "+message);
    }
}
