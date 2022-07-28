package team.oldbask.server.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.oldbask.dao.PostDao;
import team.oldbask.dao.UserDao;
import team.oldbask.domain.*;
import team.oldbask.server.PostService;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private UserDao userDao;

    @Override
    public boolean submitPost(@NotNull PostForm postForm, String uid) {
        return postDao.insert(new Post(
                Integer.parseInt(uid),
                postForm.getContent()
        )) == 1;
    }

    @Override
    public PostPage getPost(Integer pageNum, Integer size) {
        IPage<Post> page = new Page<>(pageNum, size);
        postDao.selectPage(page, null);
        PostPage postPage = new PostPage();
        postPage.setTotal((int)page.getTotal());
        postPage.setTotalPage((int)page.getPages());
        for(Post post : page.getRecords()) {
            User publisher = userDao.selectById(post.getPublisherId());
            postPage.getData().add(new PostWithUser(
                    publisher.getUsername(),
                    publisher.getType().toString(),
                    publisher.getProfile(),
                    post.getContent(),
                    post.getCreateTime().toString(),
                    post.getLikeNum(),
                    post.getCommentNum()
            ));
        }
        return postPage;
    }
}
