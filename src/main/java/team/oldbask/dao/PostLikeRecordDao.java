package team.oldbask.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import team.oldbask.domain.model.PostLikeRecord;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Mapper
public interface PostLikeRecordDao extends BaseMapper<PostLikeRecord> {

    /**
     * 通过用户id和帖子id来获取点赞记录
     * @param uid 用户id
     * @param postId 帖子id
     * @return 点赞记录
     */
    @Select("SELECT * " +
            "FROM tbl_post_like_record " +
            "WHERE uid = #{uid} AND post_id = #{postId}")
    PostLikeRecord selectByUidAndPostId(Integer uid, Integer postId);
}
