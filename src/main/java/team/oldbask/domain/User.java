package team.oldbask.domain;

import lombok.Data;

/**
 * @author Patrick_Star
 * @version 1.0
 */

@Data
public class User {

    public enum UserType {
        /**
         * 普通用户
         */
        USER,
        /**
         * 管理员
         */
        ADMIN,
        /**
         * 专家用户
         */
        EXPERT;
    }

    private Integer id;
    private String username;
    private String password;
    private String phoneNum;
    private String sex;
    private Integer age;
    private UserType type;
    private String openid;

    public User(String username, String password, String phoneNum, String sex, Integer age, String openid) {
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
        this.sex = sex;
        this.age = age;
        this.type = UserType.USER;
        this.openid = openid;
    }

    public User() {
    }
}

