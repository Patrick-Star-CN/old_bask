package team.oldbask.domain;

import lombok.Data;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Data
public class PostWithUser {
    private String publisherName;
    private String publisherType;
    private String publisherProfile;
    private String content;
    private String createTime;
    private Integer likeNum;
    private Integer commentNum;

    public PostWithUser(String publisherName, String publisherType, String publisherProfile, String content, String createTime, Integer likeNum, Integer commentNum) {
        this.publisherName = publisherName;
        this.publisherType = publisherType;
        this.publisherProfile = publisherProfile;
        this.content = content;
        this.createTime = createTime;
        this.likeNum = likeNum;
        this.commentNum = commentNum;
    }
}
