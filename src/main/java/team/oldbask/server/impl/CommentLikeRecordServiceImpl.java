package team.oldbask.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.oldbask.dao.CommentLikeRecordDao;
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

    @Override
    public Boolean like(Integer commentId, Integer uid) {
        CommentLikeRecord commentLikeRecord = commentLikeRecordDao.selectByUidAndCommentId(uid, commentId);
        if(commentLikeRecord == null) {
            return commentLikeRecordDao.insert(new CommentLikeRecord(
                    commentId,
                    uid
            )) == 1;
        }
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
