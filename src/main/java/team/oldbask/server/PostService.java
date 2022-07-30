package team.oldbask.server;

import org.springframework.stereotype.Service;
import team.oldbask.domain.form.PostForm;
import team.oldbask.domain.PostPage;

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
     * @return true: 保存成功; false: 保存失败
     */
    boolean submitPost(PostForm postForm, String uid);

    /**
     * 获取分页的帖子数据
     * @param pageNum 当前页码
     * @param size 每页数量
     * @return Page对象
     */
    PostPage getPost(Integer pageNum, Integer size);
}
