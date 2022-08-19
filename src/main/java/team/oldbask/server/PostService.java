package team.oldbask.server;

import org.springframework.stereotype.Service;
import team.oldbask.apiException.TransactionException;
import team.oldbask.domain.PostPage;
import team.oldbask.domain.form.PostEditForm;
import team.oldbask.domain.form.PostForm;

/**
 * 帖子功能业务层接口
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
     * @param type 查询类型
     * @param uid 用户id
     * @return Page对象
     */
    PostPage getPost(Integer pageNum, Integer size, String type, Integer uid);

    /**
     * 修改帖子内容
     * @param postEditForm 修改后的帖子表单
     * @param uid 用户id
     * @return true: 保存成功; false: 保存失败
     * @throws TransactionException 用户权限异常
     */
    Boolean editPost(PostEditForm postEditForm, Integer uid) throws TransactionException;

    /**
     * 删除制定帖子
     * @param postId 帖子id
     * @param uid 用户id
     * @return true: 保存成功; false: 保存失败
     * @throws TransactionException 用户权限异常
     */
    Boolean deletePost(Integer postId, Integer uid) throws TransactionException;
}
