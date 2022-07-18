package team.oldbask.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信小程序配置类
 * @author Patrick_Star
 * @version 1.0
 */
@Component
@ConfigurationProperties("wechat")
public class WechatProperties {

    /**
     * 设置微信小程序的appid
     */
    private static String appid;

    /**
     * 设置微信小程序的Secret
     */
    private static String secret;

    public void setAppid(String appid) {
        WechatProperties.appid = appid;
    }

    public void setSecret(String secret) {
        WechatProperties.secret = secret;
    }

    public static String getAppid() {
        return appid;
    }

    public static String getSecret() {
        return secret;
    }
}
