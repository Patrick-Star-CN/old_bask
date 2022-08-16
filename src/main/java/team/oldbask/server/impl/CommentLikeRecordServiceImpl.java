package team.oldbask.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.oldbask.dao.CommentDao;
import team.oldbask.dao.CommentLikeRecordDao;
import team.oldbask.domain.model.Comment;
import team.oldbask.domain.model.CommentLikeRecord;
import team.oldbask.server.CommentLikeRecordService;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public class CommentLikeRecordServiceImpl implements CommentLikeRecordService {

    @Autowired
    private CommentLikeRecordDao commentLikeRecordDao;

    @Autowired
    private CommentDao commentDao;

    @Override
    public Boolean like(Integer commentId, Integer uid) {
        CommentLikeRecord commentLikeRecord = commentLikeRecordDao.selectByUidAndCommentId(uid, commentId);
        Comment comment = commentDao.selectById(commentId);

        if(commentLikeRecord == null) {
            commentDao.updateById(new Comment(
                    commentId,
                    comment.getPostId(),
                    comment.getPublisherId(),
                    comment.getContent(),
                    comment.getCreateTime(),
                    comment.getLikeNum() + 1
            ));
            return commentLikeRecordDao.insert(new CommentLikeRecord(
                    commentId,
                    uid
            )) == 1;
        }

        commentDao.updateById(new Comment(
                commentId,
                comment.getPostId(),
                comment.getPublisherId(),
                comment.getContent(),
                comment.getCreateTime(),
                commentLikeRecord.getIsCancel() ? comment.getLikeNum() + 1 : comment.getLikeNum() - 1
        ));

        return commentLikeRecordDao.updateById(new CommentLikeRecord(
                commentLikeRecord.getId(),
                commentLikeRecord.getCommentId(),
                commentLikeRecord.getUid(),
                !commentLikeRecord.getIsCancel()
        )) == 1;
    }

    @Override
    public Boolean isLike(Integer commentId, Integer uid) {
        CommentLikeRecord commentLikeRecord = commentLikeRecordDao.selectByUidAndCommentId(uid, commentId);
        if(commentLikeRecord == null || commentLikeRecord.getIsCancel()) {
            return false;
        }
        return true;
    }
}
