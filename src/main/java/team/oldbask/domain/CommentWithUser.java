package team.oldbask.domain;

import lombok.Data;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Data
public class CommentWithUser {
    private Integer id;
    private Integer postId;
    private Integer publisherId;
    private String publisherName;
    private String publisherType;
    private String publisherProfile;
    private String content;
    private String createTime;
    private Integer likeNum;

    public CommentWithUser(Integer id, Integer postId, Integer publisherId, String publisherName, String publisherType, String publisherProfile, String content, String createTime, Integer likeNum) {
        this.id = id;
        this.postId = postId;
        this.publisherId = publisherId;
        this.publisherName = publisherName;
        this.publisherType = publisherType;
        this.publisherProfile = publisherProfile;
        this.content = content;
        this.createTime = createTime;
        this.likeNum = likeNum;
    }
}
