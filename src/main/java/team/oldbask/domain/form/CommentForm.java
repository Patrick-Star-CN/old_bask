package team.oldbask.domain.form;

import lombok.Data;

/**
 * 帖子提交表单实体类
 * @author Patrick_Star
 * @version 1.0
 */
@Data
public class CommentForm {
    private Integer postId;
    private String content;
}
