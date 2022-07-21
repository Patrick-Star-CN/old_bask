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
    private String phoneNum;
    private String sex;
    private Integer age;
    private UserType type;
    private String openid;

    public User(Integer id, String username, String phoneNum, String sex, Integer age, UserType type, String openid) {
        this.id = id;
        this.username = username;
        this.phoneNum = phoneNum;
        this.sex = sex;
        this.age = age;
        this.type = type;
        this.openid = openid;
    }

    public User(String username, String phoneNum, String sex, Integer age, String openid) {
        this.username = username;
        this.phoneNum = phoneNum;
        this.sex = sex;
        this.age = age;
        this.type = UserType.USER;
        this.openid = openid;
    }

    public User(String username, String openid) {
        this.username = username;
        this.openid = openid;
    }

    public User() {
    }
}
