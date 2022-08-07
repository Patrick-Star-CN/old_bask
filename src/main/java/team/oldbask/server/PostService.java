package team.oldbask.server;

import org.springframework.stereotype.Service;
import team.oldbask.domain.PostPage;
import team.oldbask.domain.form.PostForm;

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
    Boolean submitPost(PostForm postForm, String uid);

    /**
     * 获取其他人发布的分页化后的帖子数据
     * @param pageNum 当前页码
     * @param size 每页数量
     * @param uid 用户id
     * @return Page对象
     */
    PostPage getOtherPost(Integer pageNum, Integer size, Integer uid);

    /**
     * 获取专家发布的分页化后的帖子数据
     * @param pageNum 当前页码
     * @param size 每页数量
     * @param uid 用户id
     * @return Page对象
     */
    PostPage getExpertPost(Integer pageNum, Integer size, Integer uid);
}
