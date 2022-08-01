package team.oldbask.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.oldbask.dao.PostDao;
import team.oldbask.dao.UserDao;
import team.oldbask.domain.PostPage;
import team.oldbask.domain.PostWithUser;
import team.oldbask.domain.form.PostForm;
import team.oldbask.domain.model.Post;
import team.oldbask.domain.model.User;
import team.oldbask.server.PostService;

import java.util.ArrayList;
import java.util.List;

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
                postForm.getContent(),
                userDao.selectById(uid).getType() == User.UserType.EXPERT ? Post.PostType.EXPERT : Post.PostType.OTHER
        )) == 1;
    }

    @Override
    public PostPage getOtherPost(Integer pageNum, Integer size) {
        return getPost(pageNum, size, Post.PostType.OTHER);
    }

    @Override
    public PostPage getExpertPost(Integer pageNum, Integer size) {
        return getPost(pageNum, size, Post.PostType.EXPERT);
    }

    private PostPage getPost(Integer pageNum, Integer size, Post.PostType type) {
        IPage<Post> page = new Page<>(pageNum, size);
        QueryWrapper<Post> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", type);
        postDao.selectPage(page, queryWrapper);
        PostPage postPage = new PostPage();
        postPage.setTotal((int)page.getTotal());
        postPage.setTotalPage((int)page.getPages());

        List<PostWithUser> list = new ArrayList<>();
        for(Post post : page.getRecords()) {
            User publisher = userDao.selectById(post.getPublisherId());
            list.add(new PostWithUser(
                    post.getId(),
                    publisher.getId(),
                    publisher.getUsername(),
                    publisher.getType().toString(),
                    publisher.getProfile(),
                    post.getContent(),
                    post.getCreateTime().toString(),
                    post.getLikeNum(),
                    post.getCommentNum()
            ));
        }
        postPage.setData(list);
        return postPage;
    }
}
