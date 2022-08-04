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
        this.createTime = new Timestamp(System.currentTimeMillis() + 28800000);
        this.likeNum = 0;
        this.commentNum = 0;
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
