package team.oldbask.domain.model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Data
public class Post {

    private Integer id;
    private Integer publisherId;
    private String content;
    private Timestamp createTime;
    private Integer likeNum;
    private Integer commentNum;
    private String type;

    public Post(Integer publisher, String content, String type) {
        this.publisherId = publisher;
        this.content = content;
        this.createTime = new Timestamp(System.currentTimeMillis());
        this.likeNum = 0;
        this.commentNum = 0;
        this.type = type;
    }

    public Post(Integer id, Integer publisherId, String content, Timestamp createTime, Integer likeNum, Integer commentNum, String type) {
        this.id = id;
        this.publisherId = publisherId;
        this.content = content;
        this.createTime = createTime;
        this.likeNum = likeNum;
        this.commentNum = commentNum;
        this.type = type;
    }

    public enum PostType {
        /**
         * 专家贴
         */
        EXPERT,
        /**
         * 其他贴
         */
        OTHER
    }
}
