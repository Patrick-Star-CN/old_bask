package team.oldbask.server;

import org.springframework.stereotype.Service;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public interface CommentLikeRecordService {

    /**
     * 点赞或取消点赞
     * @param commentId 评论id
     * @param uid 用户id
     * @return true: 修改成功; false: 修改失败
     */
    Boolean like(Integer commentId, Integer uid);

    /**
     * 是否点赞
     * @param commentId 评论id
     * @param uid 用户id
     * @return true: 已点赞; false: 未点赞
     */
    Boolean isLike(Integer commentId, Integer uid);
}
