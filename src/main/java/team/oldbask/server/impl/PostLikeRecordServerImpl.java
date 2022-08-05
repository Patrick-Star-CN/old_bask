package team.oldbask.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import team.oldbask.dao.PostLikeRecordDao;
import team.oldbask.server.PostLikeRecordServer;

/**
 * @author Patrick_Star
 * @version 1.0
 */
public class PostLikeRecordServerImpl implements PostLikeRecordServer {

    @Autowired
    private PostLikeRecordDao postLikeRecordDao;

    @Override
    public Boolean like(String postId, String uid) {
        return null;
    }

    @Override
    public Boolean isLike(String postId, String uid) {
        return null;
    }
}
