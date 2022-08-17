package team.oldbask.domain.model;

import lombok.Data;

/**
 * 用户实体类
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
    private String profile;

    public User(Integer id, String username, String phoneNum, String sex, Integer age, UserType type, String openid, String profile) {
        this.id = id;
        this.username = username;
        this.phoneNum = phoneNum;
        this.sex = sex;
        this.age = age;
        this.type = type;
        this.openid = openid;
        this.profile = profile;
    }

    public User(String username, String openid, String profile) {
        this.username = username;
        this.openid = openid;
        this.profile = profile;
        this.phoneNum = null;
        this.sex = null;
        this.age = 0;
        this.type = UserType.USER;
    }
}
