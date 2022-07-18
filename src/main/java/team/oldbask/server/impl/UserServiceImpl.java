package team.oldbask.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.oldbask.dao.UserDao;
import team.oldbask.domain.UserPostForm;
import team.oldbask.server.UserService;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public Boolean loginByWechat(UserPostForm userPostForm) {
        return null;
    }
}
