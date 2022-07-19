package team.oldbask.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.oldbask.apiException.EmBusinessError;
import team.oldbask.apiException.TransactionException;
import team.oldbask.dao.UserDao;
import team.oldbask.domain.Code2Session;
import team.oldbask.domain.User;
import team.oldbask.domain.UserPostForm;
import team.oldbask.server.UserService;
import team.oldbask.server.WechatService;
import team.oldbask.util.CommonUtil;

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
    public Boolean loginByWechat(String code) throws TransactionException {
        Code2Session session = wechatService.code2Session(code);
        if (!CommonUtil.IntegerEqual(session.getErrCode(), 0)) {
            throw new TransactionException(EmBusinessError.OPENID_ERROR);
        }

        User user = userDao.selectByOpenId(session.getOpenId());
        return user != null;
    }

    @Override
    public Boolean registerByWechat(UserPostForm userPostForm) throws TransactionException {
        Code2Session session = wechatService.code2Session(userPostForm.getCode());
        if (!CommonUtil.IntegerEqual(session.getErrCode(), 0)) {
            throw new TransactionException(EmBusinessError.OPENID_ERROR);
        }

        User user = userDao.selectByOpenId(session.getOpenId());
        if (user != null) {
            return false;
        }

        int i = userDao.insert(new User(
                userPostForm.getUsername(),
                userPostForm.getPassword(),
                userPostForm.getPhoneNum(),
                userPostForm.getSex(),
                userPostForm.getAge(),
                session.getOpenId()
        ));

        return i == 1;
    }
}
