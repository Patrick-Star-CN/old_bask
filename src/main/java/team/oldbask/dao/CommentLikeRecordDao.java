package team.oldbask.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import team.oldbask.domain.model.CommentLikeRecord;

/**
 * 评论点赞功能数据层接口
 * @author Patrick_Star
 * @version 1.0
 */
@Mapper
public interface CommentLikeRecordDao extends BaseMapper<CommentLikeRecord> {

    /**
     * 通过用户id和评论id来获取点赞记录
     * @param uid 用户id
     * @param commentId 评论id
     * @return 点赞记录
     */
    @Select("SELECT * " +
            "FROM tbl_comment_like_record " +
            "WHERE uid = #{uid} AND comment_id = #{commentId}")
    CommentLikeRecord selectByUidAndCommentId(@Param("uid") Integer uid, @Param("commentId") Integer commentId);
}
