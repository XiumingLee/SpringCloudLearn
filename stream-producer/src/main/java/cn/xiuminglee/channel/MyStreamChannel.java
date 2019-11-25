package cn.xiuminglee.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @Author Xiuming Lee
 * @Description
 */
public interface MyStreamChannel {
    String Ming_CHANNEL = "ming-output";

    @Output(Ming_CHANNEL)
    MessageChannel mingOutput();
}
