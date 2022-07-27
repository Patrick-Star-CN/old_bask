package team.oldbask.server.impl;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.oldbask.dao.PostDao;
import team.oldbask.domain.Post;
import team.oldbask.domain.PostForm;
import team.oldbask.server.PostService;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public boolean submitPost(@NotNull PostForm postForm, String uid) {
        return postDao.insert(new Post(
                Integer.parseInt(uid),
                postForm.getContent()
        )) == 1;
    }
}
