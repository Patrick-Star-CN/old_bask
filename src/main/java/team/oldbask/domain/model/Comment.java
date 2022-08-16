package team.oldbask.domain.model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Patrick_Star
 * @version 1.0
 */

@Data
public class Comment {
    private Integer id;
    private Integer postId;
    private Integer publisherId;
    private String content;
    private Timestamp createTime;
    private Integer likeNum;

    public Comment(Integer postId, Integer publisherId, String content) {
        this.postId = postId;
        this.publisherId = publisherId;
        this.content = content;
        this.createTime = new Timestamp(System.currentTimeMillis());
        this.likeNum = 0;
    }

    public Comment(Integer id, Integer postId, Integer publisherId, String content, Timestamp createTime, Integer likeNum) {
        this.id = id;
        this.postId = postId;
        this.publisherId = publisherId;
        this.content = content;
        this.createTime = createTime;
        this.likeNum = likeNum;
    }
}
