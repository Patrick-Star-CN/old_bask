package team.oldbask.server;

import team.oldbask.domain.Code2Session;

/**
 * @author Patrick_Star
 * @version 1.0
 */
public interface WechatService {

    /**
     * code换取openId
     * @param code code
     * @return session对象
     */
    Code2Session code2Session(String code);
}
