package team.oldbask.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import team.oldbask.domain.model.Post;

/**
 * 帖子功能数据层接口
 * @author Patrick_Star
 * @version 1.0
 */
@Mapper
public interface PostDao extends BaseMapper<Post> {
}
