package team.oldbask.domain.model;

import lombok.Data;

/**
 * 评论点赞记录实体类
 * @author Patrick_Star
 * @version 1.0
 */
@Data
public class CommentLikeRecord {
    private Integer id;
    private Integer commentId;
    private Integer uid;
    private Boolean isCancel;

    public CommentLikeRecord(Integer id, Integer commentId, Integer uid, Boolean isCancel) {
        this.id = id;
        this.commentId = commentId;
        this.uid = uid;
        this.isCancel = isCancel;
    }

    public CommentLikeRecord(Integer commentId, Integer uid) {
        this.commentId = commentId;
        this.uid = uid;
        this.isCancel = false;
    }
}
