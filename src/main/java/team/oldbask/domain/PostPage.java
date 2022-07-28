package team.oldbask.domain;

import lombok.Data;

import java.util.List;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Data
public class PostPage {
    private List<PostWithUser> data;
    private Integer totalPage;
    private Integer total;
}