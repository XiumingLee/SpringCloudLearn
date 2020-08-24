package cn.xiuminglee.boot.admin.entity;

/**
 * @author Xiuming Lee
 * description  文档：https://ding-doc.dingtalk.com/doc#/serverapi2/qf2nxq/e9d991e2
 */
public class DingDingMessage {

    private String msgtype;
    private String text;
    private String at = "{\n" +
            "        \"atMobiles\": [\n" +
            "            \"17115517710\" \n" +
            "        ], \n" +
            "        \"isAtAll\": true\n" +
            "    }";
    public String getMsgtype() {
        return msgtype;
    }
    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }
}
