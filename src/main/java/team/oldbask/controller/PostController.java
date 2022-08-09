package team.oldbask.controller;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.oldbask.apiException.EmBusinessError;
import team.oldbask.domain.form.PostForm;
import team.oldbask.domain.model.Post;
import team.oldbask.server.PostLikeRecordServer;
import team.oldbask.server.PostService;
import team.oldbask.util.RespJson;

import javax.servlet.http.HttpServletRequest;

/**
 * 帖子功能显示层控制器
 * @author Patrick_Star
 * @version 1.0
 */

@Slf4j
@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostLikeRecordServer postLikeRecordServer;

    @ResponseBody
    @PostMapping
    public RespJson submitPost(@RequestBody PostForm postForm, @NotNull HttpServletRequest request) {
        String uid = (String)request.getSession().getAttribute("id");
        if(postService.submitPost(postForm, uid)) {
            log.info("submitPost-200-OK");
            return new RespJson(200,"OK");
        } else {
            log.info("submitPost-" + EmBusinessError.DATABASE_CONNECTION_ERROR.getErrorCode()
                    + "-" + EmBusinessError.DATABASE_CONNECTION_ERROR.getErrorMsg());
            return new RespJson(EmBusinessError.DATABASE_CONNECTION_ERROR.getErrorCode(),
                    EmBusinessError.DATABASE_CONNECTION_ERROR.getErrorMsg());
        }
    }

    @ResponseBody
    @GetMapping
    public RespJson getOtherPost(@RequestParam Integer pageNum, @RequestParam Integer size, @NotNull HttpServletRequest request) {
        String uid = (String)request.getSession().getAttribute("id");
        log.info("getOtherPost-200-OK");
        return new RespJson(200, "OK", postService.getPost(pageNum, size, Post.PostType.OTHER.toString(), Integer.parseInt(uid)));
    }

    @ResponseBody
    @GetMapping("/expert")
    public RespJson getExpertPost(@RequestParam Integer pageNum, @RequestParam Integer size, @NotNull HttpServletRequest request) {
        String uid = (String)request.getSession().getAttribute("id");
        log.info("getExpertPost-200-OK");
        return new RespJson(200, "OK", postService.getPost(pageNum, size, Post.PostType.EXPERT.toString(), Integer.parseInt(uid)));
    }

    @ResponseBody
    @GetMapping("/like")
    public RespJson likePost(@RequestParam Integer postId, @NotNull HttpServletRequest request) {
        String uid = (String)request.getSession().getAttribute("id");
        if(postLikeRecordServer.like(postId, Integer.parseInt(uid))) {
            log.info("likePost-200-OK");
            return new RespJson(200,"OK");
        }
        log.info("likePost-" + EmBusinessError.PARAMETER_ERROR.getErrorCode()
                + "-" + EmBusinessError.PARAMETER_ERROR.getErrorMsg());
        return new RespJson(EmBusinessError.PARAMETER_ERROR.getErrorCode(),
                EmBusinessError.PARAMETER_ERROR.getErrorMsg());
    }
}
