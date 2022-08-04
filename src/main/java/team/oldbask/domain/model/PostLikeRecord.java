package team.oldbask.domain.model;

import lombok.Data;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Data
public class PostLikeRecord {
    private Integer id;
    private Integer postId;
    private Integer uid;
    private Boolean isCancel;
}
