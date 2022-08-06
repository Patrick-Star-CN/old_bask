package team.oldbask.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.oldbask.dao.PostLikeRecordDao;
import team.oldbask.domain.model.PostLikeRecord;
import team.oldbask.server.PostLikeRecordServer;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public class PostLikeRecordServerImpl implements PostLikeRecordServer {

    @Autowired
    private PostLikeRecordDao postLikeRecordDao;

    @Override
    public Boolean like(Integer postId, Integer uid) {
        PostLikeRecord postLikeRecord = postLikeRecordDao.selectByUidAndPostId(uid, postId);
        if(postLikeRecord == null) {
            return postLikeRecordDao.insert(new PostLikeRecord(
                    postId,
                    uid
            )) == 1;
        }
        return postLikeRecordDao.updateById(new PostLikeRecord(
                postLikeRecord.getId(),
                postLikeRecord.getPostId(),
                postLikeRecord.getUid(),
                !postLikeRecord.getIsCancel()
        )) == 1;
    }

    @Override
    public Boolean isLike(Integer postId, Integer uid) {
        PostLikeRecord postLikeRecord = postLikeRecordDao.selectByUidAndPostId(uid, postId);
        if(postLikeRecord == null || postLikeRecord.getIsCancel()) {
            return false;
        }
        return true;
    }
}
