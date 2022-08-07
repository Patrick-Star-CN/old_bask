package team.oldbask.server;

import org.springframework.stereotype.Service;
import team.oldbask.domain.CommentPage;
import team.oldbask.domain.form.CommentForm;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public interface CommentService {

    /**
     * 保存评论
     * @param commentForm
     * @param uid
     * @return true: 保存成功; false: 保存失败
     */
    Boolean submitComment(CommentForm commentForm, String uid);

    /**
     * 获取分页的评论数据
     * @param postId 帖子id
     * @param pageNum 当前页码
     * @param size 每页数量
     * @param uid 用户id
     * @return Page对象
     */
    CommentPage getComment(Integer postId, Integer pageNum, Integer size, Integer uid);
}
