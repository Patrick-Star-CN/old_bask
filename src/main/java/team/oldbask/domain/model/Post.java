package team.oldbask.domain.model;

import lombok.Data;
import java.sql.Timestamp;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Data
public class Post {

    public enum PostType {
        /**
         * 普通帖
         */
        OTHER,
        /**
         * 专家帖
         */
        EXPERT;
    }

    private Integer id;
    private Integer publisherId;
    private String content;
    private Timestamp createTime;
    private Integer likeNum;
    private Integer commentNum;
    private PostType type;

    public Post(Integer publisher, String content, PostType type) {
        this.publisherId = publisher;
        this.content = content;
        this.createTime = new Timestamp(System.currentTimeMillis() + 28800000);
        this.likeNum = 0;
        this.commentNum = 0;
        this.type = type;
    }
}
