package team.oldbask.server;

import org.springframework.stereotype.Service;
import team.oldbask.apiException.TransactionException;
import team.oldbask.domain.User;
import team.oldbask.domain.UserInfoForm;
import team.oldbask.domain.UserPostForm;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public interface UserService {

    /**
     * 微信登录
     * @param code 用户的code
     * @return uid: 登录成功; null: 不存在该用户
     * @throws TransactionException openid错误
     */
    Integer loginByWechat(String code) throws TransactionException;

    /**
     * 微信注册
     * @param userPostForm 前端提交的用户数据表单
     * @return uid: 注册成功; null: 用户已存在
     * @throws TransactionException openid错误
     */
    Integer registerByWechat(UserPostForm userPostForm) throws TransactionException;

    /**
     * 通过uid获取用户信息
     * @param uid uid
     * @return 用户信息对象
     */
    User getUserInfo(String uid);

    /**
     * 保存用户信息
     * @param userInfoForm 待保存的用户信息
     * @param uid uid
     * @return true: 保存成功; false: 保存失败
     */
    void submitUserInfo(UserInfoForm userInfoForm, String uid);
}
