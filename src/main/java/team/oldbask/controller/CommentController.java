package team.oldbask.controller;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.oldbask.apiException.EmBusinessError;
import team.oldbask.domain.form.CommentForm;
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
    public RespJson getComment(@RequestParam Integer pageNum, @RequestParam Integer size, @RequestParam Integer postId) {
        log.info("getComment-200-OK");
        return new RespJson(200, "OK", commentService.getComment(postId, pageNum, size));
    }
}
