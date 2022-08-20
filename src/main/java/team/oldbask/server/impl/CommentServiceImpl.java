package team.oldbask.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.oldbask.apiException.EmBusinessError;
import team.oldbask.apiException.TransactionException;
import team.oldbask.dao.CommentDao;
import team.oldbask.dao.PostDao;
import team.oldbask.dao.UserDao;
import team.oldbask.domain.CommentPage;
import team.oldbask.domain.CommentWithUser;
import team.oldbask.domain.form.CommentEditForm;
import team.oldbask.domain.form.CommentForm;
import team.oldbask.domain.model.Comment;
import team.oldbask.domain.model.Post;
import team.oldbask.domain.model.User;
import team.oldbask.server.CommentLikeRecordService;
import team.oldbask.server.CommentService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CommentLikeRecordService commentLikeRecordService;

    @Autowired
    private PostDao postDao;

    @Override
    public Boolean submitComment(CommentForm commentForm, String uid) {
        Post post = postDao.selectById(commentForm.getPostId());
        postDao.updateById(new Post(
                post.getId(),
                post.getPublisherId(),
                post.getContent(),
                post.getCreateTime(),
                post.getLikeNum(),
                post.getCommentNum() + 1,
                post.getType()
        ));
        return commentDao.insert(new Comment(
                commentForm.getPostId(),
                Integer.parseInt(uid),
                commentForm.getContent()
        )) == 1;
    }

    @Override
    public CommentPage getComment(Integer postId, Integer pageNum, Integer size, Integer uid) {
        IPage<Comment> page = new Page<>(pageNum, size);
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(postId != null, Comment::getPostId, postId);
        commentDao.selectPage(page, queryWrapper);
        CommentPage commentPage = new CommentPage();
        commentPage.setTotal((int)page.getTotal());
        commentPage.setTotalPage((int)page.getPages());

        List<CommentWithUser> list = new ArrayList<>();
        for(Comment comment : page.getRecords()) {
            User publisher = userDao.selectById(comment.getPublisherId());
            list.add(new CommentWithUser(
                    comment.getId(),
                    comment.getPostId(),
                    publisher.getId(),
                    publisher.getUsername(),
                    publisher.getType().toString(),
                    publisher.getProfile(),
                    comment.getContent(),
                    comment.getCreateTime().toString(),
                    comment.getLikeNum(),
                    commentLikeRecordService.isLike(comment.getId(), uid)
            ));
        }
        commentPage.setData(list);
        return commentPage;
    }

    @Override
    public Boolean editComment(CommentEditForm commentEditForm, Integer uid) throws TransactionException {
        Comment comment = commentDao.selectById(commentEditForm.getCommentId());
        if(!comment.getPublisherId().equals(uid)) {
            throw new TransactionException(EmBusinessError.USER_PERMISSION_ERROR);
        }

        return commentDao.updateById(new Comment(
                comment.getId(),
                comment.getPostId(),
                comment.getPublisherId(),
                commentEditForm.getContent(),
                comment.getCreateTime(),
                comment.getLikeNum()
        )) == 1;
    }

    @Override
    public Boolean deleteComment(Integer commentId, Integer uid) throws TransactionException {
        Comment comment = commentDao.selectById(commentId);
        if(!comment.getPublisherId().equals(uid)) {
            throw new TransactionException(EmBusinessError.USER_PERMISSION_ERROR);
        }

        if(commentDao.deleteById(commentId) != 1) {
            return false;
        }
        
        Post post = postDao.selectById(comment.getPostId());
        postDao.updateById(new Post(
                post.getId(),
                post.getPublisherId(),
                post.getContent(),
                post.getCreateTime(),
                post.getLikeNum(),
                post.getCommentNum() - 1,
                post.getType()
        ));
        return true;
    }
}
