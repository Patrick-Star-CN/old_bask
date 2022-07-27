package team.oldbask.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.oldbask.domain.PostForm;

/**
 * @author Patrick_Star
 * @version 1.0
 */

@Service
public interface PostService {

    /**
     * 保存帖子
     * @param postForm 前端提交的帖子数据表单
     * @param uid uid
     * @return 1: 保存成功; 2: 保存失败
     */
    boolean submitPost(PostForm postForm, String uid);
}
