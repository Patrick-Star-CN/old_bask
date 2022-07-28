package team.oldbask.domain;

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

    public Post(Integer publisher, String content) {
        this.publisherId = publisher;
        this.content = content;
        this.createTime = new Timestamp(System.currentTimeMillis() + 28800000);
        this.likeNum = 0;
        this.commentNum = 0;
    }
}
