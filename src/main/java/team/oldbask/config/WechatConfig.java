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
public class WechatConfig {
    private static String appId;
    private static String appSecret;

    public void setAppId(String appId) {
        WechatConfig.appId = appId;
    }

    public void setAppSecret(String appSecret) {
        WechatConfig.appSecret = appSecret;
    }

    public static String getAppId() {
        return appId;
    }

    public static String getAppSecret() {
        return appSecret;
    }
}
