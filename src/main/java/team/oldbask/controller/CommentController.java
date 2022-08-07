package team.oldbask.controller;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.oldbask.apiException.EmBusinessError;
import team.oldbask.domain.form.CommentForm;
import team.oldbask.server.CommentLikeRecordService;
import team.oldbask.server.CommentService;
import team.oldbask.util.RespJson;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Patrick_Star
 * @version 1.0
 */

@Slf4j
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentLikeRecordService commentLikeRecordService;

    @ResponseBody
    @PostMapping
    public RespJson submitComment(@RequestBody CommentForm commentForm, @NotNull HttpServletRequest request) {
        String uid = (String)request.getSession().getAttribute("id");
        if(commentService.submitComment(commentForm, uid)) {
            log.info("submitComment-200-OK");
            return new RespJson(200, "OK");
        } else {
            log.info("submitComment-" + EmBusinessError.DATABASE_CONNECTION_ERROR.getErrorCode()
                    + "-" + EmBusinessError.DATABASE_CONNECTION_ERROR.getErrorMsg());
            return new RespJson(EmBusinessError.DATABASE_CONNECTION_ERROR.getErrorCode(),
                    EmBusinessError.DATABASE_CONNECTION_ERROR.getErrorMsg());
        }
    }

    @ResponseBody
    @GetMapping
    public RespJson getComment(@RequestParam Integer pageNum, @RequestParam Integer size, @RequestParam Integer postId, @NotNull HttpServletRequest request) {
        String uid = (String)request.getSession().getAttribute("id");
        log.info("getComment-200-OK");
        return new RespJson(200, "OK", commentService.getComment(postId, pageNum, size, Integer.parseInt(uid)));
    }

    @ResponseBody
    @GetMapping("/like")
    public RespJson likeComment(@RequestParam Integer commentId, @NotNull HttpServletRequest request) {
        String uid = (String)request.getSession().getAttribute("id");
        if(commentLikeRecordService.like(commentId, Integer.parseInt(uid))) {
            log.info("likeComment-200-OK");
            return new RespJson(200,"OK");
        }
        log.info("likeComment-" + EmBusinessError.PARAMETER_ERROR.getErrorCode()
                + "-" + EmBusinessError.PARAMETER_ERROR.getErrorMsg());
        return new RespJson(EmBusinessError.PARAMETER_ERROR.getErrorCode(),
                EmBusinessError.PARAMETER_ERROR.getErrorMsg());
    }
}
