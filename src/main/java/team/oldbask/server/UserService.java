package team.oldbask.server;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import team.oldbask.domain.UserPostForm;
import team.oldbask.domain.User;
import team.oldbask.util.RespJson;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public interface UserService {

    /**
     * 微信登录接口
     * @param userPostForm 用户数据提交表单
     * @return true: 登录成功; false: 登录失败
     */
    Boolean loginByWechat(UserPostForm userPostForm);
}
