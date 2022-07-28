package team.oldbask.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import team.oldbask.domain.Post;
import team.oldbask.domain.PostForm;
import team.oldbask.domain.PostPage;

/**
 * @author Patrick_Star
 * @version 1.0
 */

@Service
public interface PostService {

    /**
     * 保存帖子
     * @param postForm 前端提交的帖子数据表单
     * @param uid uid
     * @return 1: 保存成功; 2: 保存失败
     */
    boolean submitPost(PostForm postForm, String uid);

    /**
     * 获取分页的帖子数据
     * @param pageNum 当前页码
     * @param numPerPage 每页数量
     * @return Page对象
     */
    PostPage getPost(Integer pageNum, Integer numPerPage);
}
