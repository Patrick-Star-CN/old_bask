package team.oldbask.domain;

import lombok.Data;

import java.util.List;

/**
 * 评论分页实体类
 * @author Patrick_Star
 * @version 1.0
 */
@Data
public class CommentPage {
    private List<CommentWithUser> data;
    private Integer totalPage;
    private Integer total;
}
