package cn.xiuminglee.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

/**
 * @Author Xiuming Lee
 * @Description
 */
public interface MyStreamChannel {
    String Ming_CHANNEL = "ming-input";

    @Input(Ming_CHANNEL)
    MessageChannel mingInput();
}
