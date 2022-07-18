package team.oldbask.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import team.oldbask.domain.User;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
