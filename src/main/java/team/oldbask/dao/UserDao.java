package team.oldbask.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import team.oldbask.domain.User;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

    /**
     * 通过openid来获取用户信息
     * @param openId openid
     * @return 用户信息
     */
    @Select("SELECT * FROM tbl_user WHERE openid = #{openId}")
    User selectByOpenId(String openId);
}
