package team.oldbask.server.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import team.oldbask.config.WechatProperties;
import team.oldbask.domain.Code2Session;
import team.oldbask.server.WechatService;
import team.oldbask.util.CommonUtil;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public class WechatServiceImpl implements WechatService {

    @Override
    public Code2Session code2Session(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?" +
                "appid=" + WechatProperties.getAppid() +
                "&secret=" + WechatProperties.getSecret() +
                "&js_code=" + code +
                "&grant_type=authorization_code";
        String result = HttpUtil.get(url);
        JSONObject jsonObject = JSONObject.parseObject(result);
        Code2Session code2Session = new Code2Session().setOpenId(jsonObject.getString("openid"))
                .setSessionKey(jsonObject.getString("session_key"))
                .setUnionId(jsonObject.getString("unionid"))
                .setErrCode(jsonObject.getInteger("errcode"))
                .setErrMsg(jsonObject.getString("errmsg"));
        if (StringUtils.isEmpty(code2Session.getOpenId())) {
            code2Session.setErrMsg("OpenId为空");
        } else if (CommonUtil.IntegerEqual(code2Session.getErrCode(), -1)) {
            code2Session.setErrMsg("系统繁忙，此时请开发者稍候再试");
        } else if (CommonUtil.IntegerEqual(code2Session.getErrCode(), 40029)) {
            code2Session.setErrMsg("code 无效");
        } else if (CommonUtil.IntegerEqual(code2Session.getErrCode(), 45011)) {
            code2Session.setErrMsg("频率限制，每个用户每分钟100次");
        }
        return code2Session;
    }
}
