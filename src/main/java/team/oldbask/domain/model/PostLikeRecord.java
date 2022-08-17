package team.oldbask.domain.model;

import lombok.Data;

/**
 * 帖子点赞记录实体类
 * @author Patrick_Star
 * @version 1.0
 */
@Data
public class PostLikeRecord {
    private Integer id;
    private Integer postId;
    private Integer uid;
    private Boolean isCancel;

    public PostLikeRecord(Integer postId, Integer uid) {
        this.postId = postId;
        this.uid = uid;
        this.isCancel = false;
    }

    public PostLikeRecord(Integer id, Integer postId, Integer uid, Boolean isCancel) {
        this.id = id;
        this.postId = postId;
        this.uid = uid;
        this.isCancel = isCancel;
    }
}
