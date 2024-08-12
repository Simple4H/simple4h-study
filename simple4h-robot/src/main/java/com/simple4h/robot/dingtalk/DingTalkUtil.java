package com.simple4h.robot.dingtalk;

import com.alibaba.fastjson2.JSON;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 钉钉工具类
 *
 * @author Simple4H
 */
@UtilityClass
@Slf4j
public class DingTalkUtil {

    public static final String CUSTOM_ROBOT_TOKEN = "CUSTOM_ROBOT_TOKEN";

    public static final String SECRET = "SECRET";

//    public OapiRobotSendResponse sendMessage(String message) {
//        try {
//            Long timestamp = System.currentTimeMillis();
//            String stringToSign = timestamp + "\n" + SECRET;
//            Mac mac = Mac.getInstance("HmacSHA256");
//            mac.init(new SecretKeySpec(SECRET.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
//            byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
//            String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), StandardCharsets.UTF_8);
//
//
//            //sign字段和timestamp字段必须拼接到请求URL上，否则会出现 310000 的错误信息
//            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?sign=" + sign + "&timestamp=" + timestamp);
//            OapiRobotSendRequest req = new OapiRobotSendRequest();
//
//            //定义文本内容
//            OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
//            text.setContent(message);
//            //定义 @ 对象
//            OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
////            at.setAtUserIds(List.of(USER_ID));
//            //设置消息类型
//            req.setMsgtype("text");
//            req.setText(text);
//            req.setAt(at);
//            return client.execute(req, CUSTOM_ROBOT_TOKEN);
//        } catch (ApiException | NoSuchAlgorithmException | InvalidKeyException e) {
//            throw new RuntimeException(e);
//        }
//    }

    private Boolean sendMarkDown(String title, String content) {


        Long timestamp = System.currentTimeMillis();
        String sign = getSign(timestamp);

        //sign字段和timestamp字段必须拼接到请求URL上，否则会出现 310000 的错误信息
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?sign=" + sign + "&timestamp=" + timestamp);
        OapiRobotSendRequest req = new OapiRobotSendRequest();
        req.setMsgtype("markdown");

        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();


        markdown.setTitle(title);
        markdown.setText(content);
        req.setMarkdown(markdown);
        try {
            OapiRobotSendResponse execute = client.execute(req, CUSTOM_ROBOT_TOKEN);
            boolean isSuccess = execute.getErrcode() == 0;
            if (isSuccess) {
                return true;
            }
            log.error("发送钉钉信息异常：{}", JSON.toJSONString(execute));
            return false;

        } catch (ApiException e) {
            log.error("钉钉异常", e);
            throw new RuntimeException("钉钉异常");
        }
    }

    /**
     * 获取签名
     *
     * @param timestamp 当前时间戳
     * @return 签名
     */
    private String getSign(Long timestamp) {
        String stringToSign = timestamp + "\n" + SECRET;
        Mac mac;
        try {
            mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(SECRET.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException("获取钉钉签名异常");
        }

        byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
        return URLEncoder.encode(new String(Base64.encodeBase64(signData)), StandardCharsets.UTF_8);
    }


    public static void main(String[] args) {
        DingTalkUtil.sendMarkDown("实时电价异常提醒", "你好呀，声哥");
    }
}
