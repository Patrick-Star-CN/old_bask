package team.oldbask.domain;

import lombok.Data;

/**
 * @author Patrick_Star
 * @version 1.0
 */

@Data
public class UserPostForm {
    private String username;
    private String password;
    private String phoneNum;
    private String sex;
    private Integer age;
    private String code;
}
