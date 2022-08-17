package team.oldbask.domain.form;

import lombok.Data;

/**
 * 用户信息提交表单实体类
 * @author Patrick_Star
 * @version 1.0
 */
@Data
public class UserInfoForm {
    private String username;
    private String phoneNum;
    private String sex;
    private Integer age;
    private String profile;
}
