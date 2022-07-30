package team.oldbask.server;

import org.springframework.stereotype.Service;
import team.oldbask.domain.model.Health;
import team.oldbask.domain.form.HealthForm;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public interface HealthService {

    /**
     * 保存用户健康记录
     * @param healthPostForm 健康记录对象
     * @param uid 用户id
     * @return true: 保存成功; false: 保存失败
     */
    boolean submitHealth(HealthForm healthPostForm, String uid);

    /**
     * 通过uid来获取数据
     * @param uid uid
     * @return 健康记录对象
     */
    Health getHealth(String uid);
}
