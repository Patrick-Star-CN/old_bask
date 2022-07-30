package team.oldbask.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import team.oldbask.domain.model.Comment;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Mapper
public interface CommentDao extends BaseMapper<Comment> {
}
