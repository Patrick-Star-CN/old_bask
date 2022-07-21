package team.oldbask.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.oldbask.apiException.EmBusinessError;
import team.oldbask.apiException.TransactionException;
import team.oldbask.dao.UserDao;
import team.oldbask.domain.Code2Session;
import team.oldbask.domain.User;
import team.oldbask.domain.UserInfoForm;
import team.oldbask.domain.UserPostForm;
import team.oldbask.server.UserService;
import team.oldbask.server.WechatService;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private WechatService wechatService;


    @Override
    public Integer loginByWechat(String code) throws TransactionException {
        Code2Session session = wechatService.code2Session(code);
        if (session.getErrCode() != null) {
            throw new TransactionException(EmBusinessError.OPENID_ERROR);
        }

        User user = userDao.selectByOpenId(session.getOpenId());
        if (user == null) {
            return null;
        }
        return user.getId();
    }

    @Override
    public User getUserInfo(String uid) {
        return userDao.selectById(Integer.parseInt(uid));
    }

    @Override
    public Integer registerByWechat(UserPostForm userPostForm) throws TransactionException {
        Code2Session session = wechatService.code2Session(userPostForm.getCode());
        if (session.getErrCode() != null) {
            throw new TransactionException(EmBusinessError.OPENID_ERROR);
        }
        if (userDao.selectByOpenId(session.getOpenId()) != null) {
            return null;
        }

        userDao.insert(new User(
            userPostForm.getUsername(),
            session.getOpenId()
        ));
        return userDao.selectByOpenId(session.getOpenId()).getId();
    }

    @Override
    public Boolean submitUserInfo(UserInfoForm userInfoForm, String uid) {
        User user = userDao.selectById(Integer.parseInt(uid));
        return userDao.updateById(new User(
                Integer.parseInt(uid),
                userInfoForm.getUsername(),
                userInfoForm.getPhoneNum(),
                userInfoForm.getSex(),
                userInfoForm.getAge(),
                user.getType(),
                user.getOpenid()
        )) == 1;
    }
}
