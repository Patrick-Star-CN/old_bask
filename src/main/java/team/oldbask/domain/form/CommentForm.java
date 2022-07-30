package team.oldbask.domain.form;

import lombok.Data;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Data
public class CommentForm {
    private Integer postId;
    private String content;
}
