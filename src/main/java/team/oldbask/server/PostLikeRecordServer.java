package team.oldbask.server;

import org.springframework.stereotype.Service;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public interface PostLikeRecordServer {

    /**
     * 点赞或取消点赞
     * @param postId 帖子id
     * @param uid 用户id
     * @return true: 修改成功; false: 修改失败
     */
    Boolean like(String postId, String uid);

    /**
     * 是否点赞
     * @param postId 帖子id
     * @param uid 用户id
     * @return true: 已点赞; false: 未点赞
     */
    Boolean isLike(String postId, String uid);
}
