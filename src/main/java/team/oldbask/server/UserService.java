package team.oldbask.server;

import org.springframework.stereotype.Service;
import team.oldbask.apiException.TransactionException;
import team.oldbask.domain.UserPostForm;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public interface UserService {

    /**
     * 微信登录接口
     * @param code 用户的code
     * @return true: 登录成功; false: 不存在该用户
     * @throws TransactionException openid错误
     */
    Boolean loginByWechat(String code) throws TransactionException;

    /**
     * 微信注册接口
     * @param userPostForm 前端提交的用户数据表单
     * @return true: 注册成功; false: 用户已存在
     * @throws TransactionException openid错误
     */
    Boolean registerByWechat(UserPostForm userPostForm) throws TransactionException;
}
