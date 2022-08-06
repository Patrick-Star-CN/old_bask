package team.oldbask.domain;

import lombok.Data;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Data
public class PostWithUser {
    private Integer id;
    private Integer publisherId;
    private String publisherName;
    private String publisherType;
    private String publisherProfile;
    private String content;
    private String createTime;
    private Integer likeNum;
    private Integer commentNum;
    private Boolean isLike;

    public PostWithUser(Integer id, Integer publisherId, String publisherName, String publisherType, String publisherProfile, String content, String createTime, Integer likeNum, Integer commentNum, Boolean isLike) {
        this.id = id;
        this.publisherId = publisherId;
        this.publisherName = publisherName;
        this.publisherType = publisherType;
        this.publisherProfile = publisherProfile;
        this.content = content;
        this.createTime = createTime;
        this.likeNum = likeNum;
        this.commentNum = commentNum;
        this.isLike = isLike;
    }
}
