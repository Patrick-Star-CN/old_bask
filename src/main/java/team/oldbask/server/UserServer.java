package team.oldbask.server;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.oldbask.dao.UserDao;
import team.oldbask.domain.User;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public interface UserServer extends IService<User> {
    Boolean loginByWechat();
}
