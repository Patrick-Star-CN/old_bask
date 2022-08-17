package team.oldbask.domain.form;

import lombok.Data;

/**
 * 用户注册提交表单实体类
 * @author Patrick_Star
 * @version 1.0
 */

@Data
public class UserForm {
    private String username;
    private String code;
    private String profile;
}
