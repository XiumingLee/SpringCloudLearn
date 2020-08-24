package cn.xiuminglee.boot.admin.notifier;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.xiuminglee.boot.admin.entity.DingDingMessage;
import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.notify.AbstractStatusChangeNotifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xiuming Lee
 * description 向钉钉群中发信息
 */
@Component
public class DingDingNotifier extends AbstractStatusChangeNotifier {

    public static String access_token = "501d9a916eaf03af719b562890e088ac70a6cf367e8e7b430c6c237f5b6b45cd";

    public DingDingNotifier(InstanceRepository repository) {
        super(repository);
    }

    @Override
    protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {
        String serviceName = instance.getRegistration().getName();
        String serviceUrl = instance.getRegistration().getServiceUrl();
        String status = instance.getStatusInfo().getStatus();
        Map<String, Object> details = instance.getStatusInfo().getDetails();
        StringBuilder str = new StringBuilder();
        str.append("服务预警 : 【" + serviceName + "】");
        str.append("【服务地址】" + serviceUrl);
        str.append("【状态】" + status);
        str.append("【详情】" + new JSONObject(details));
        return Mono.fromRunnable(() -> {
            System.out.println(str.toString());
            //sendTextMessage(str.toString());
        });
    }

    void sendTextMessage(String msg) {
        String url = "https://oapi.dingtalk.com/robot/send?access_token=" + access_token;

        DingDingMessage message = new DingDingMessage();
        message.setMsgtype("text");
        Map<String, String> map = new HashMap<>();
        map.put("content",msg);
        message.setText(new JSONObject(map).toString());
        String messageStr = new JSONObject(message).toString();

        HttpResponse execute = HttpRequest.post(url)
                .header("Content-Type", "application/Json; charset=UTF-8")
                .body(messageStr)
                .execute();
        String body = execute.body();

        System.out.println("-----------消息发送完成！---------");
        System.out.println(body);
        System.out.println(execute.getStatus());
    }
}
