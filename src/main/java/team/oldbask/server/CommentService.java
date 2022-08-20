package team.oldbask.server;

import org.springframework.stereotype.Service;
import team.oldbask.apiException.TransactionException;
import team.oldbask.domain.CommentPage;
import team.oldbask.domain.form.CommentEditForm;
import team.oldbask.domain.form.CommentForm;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public interface CommentService {

    /**
     * 保存评论
     * @param commentForm 评论提交表单对象
     * @param uid 用户id
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

    /**
     * 修改帖子内容
     * @param commentEditForm 修改后的帖子表单
     * @param uid 用户id
     * @return true: 保存成功; false: 保存失败
     * @throws TransactionException 用户权限异常
     */
    Boolean editComment(CommentEditForm commentEditForm, Integer uid) throws TransactionException;

    /**
     * 删除制定帖子
     * @param commentId 帖子id
     * @param uid 用户id
     * @return true: 保存成功; false: 保存失败
     * @throws TransactionException 用户权限异常
     */
    Boolean deleteComment(Integer commentId, Integer uid) throws TransactionException;
}
