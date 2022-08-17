package team.oldbask.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.oldbask.dao.PostDao;
import team.oldbask.dao.PostLikeRecordDao;
import team.oldbask.domain.model.Post;
import team.oldbask.domain.model.PostLikeRecord;
import team.oldbask.server.PostLikeRecordServer;

/**
 * 帖子点赞记录业务层实践类
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public class PostLikeRecordServerImpl implements PostLikeRecordServer {

    @Autowired
    private PostLikeRecordDao postLikeRecordDao;

    @Autowired
    private PostDao postDao;

    @Override
    public Boolean like(Integer postId, Integer uid) {
        PostLikeRecord postLikeRecord = postLikeRecordDao.selectByUidAndPostId(uid, postId);
        Post post = postDao.selectById(postId);
        if(postLikeRecord == null) {
            postDao.updateById(new Post(
                    postId,
                    post.getPublisherId(),
                    post.getContent(),
                    post.getCreateTime(),
                    post.getLikeNum() + 1,
                    post.getCommentNum(),
                    post.getType()
            ));
            return postLikeRecordDao.insert(new PostLikeRecord(
                    postId,
                    uid
            )) == 1;
        }
        postDao.updateById(new Post(
                postId,
                post.getPublisherId(),
                post.getContent(),
                post.getCreateTime(),
                postLikeRecord.getIsCancel() ? post.getLikeNum() + 1 : post.getLikeNum() - 1,
                post.getCommentNum(),
                post.getType()
        ));
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
