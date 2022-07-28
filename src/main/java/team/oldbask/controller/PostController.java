package team.oldbask.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.oldbask.apiException.EmBusinessError;
import team.oldbask.domain.Post;
import team.oldbask.domain.PostForm;
import team.oldbask.server.PostService;
import team.oldbask.util.RespJson;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Patrick_Star
 * @version 1.0
 */

@Slf4j
@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

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
    public RespJson getPost(@RequestParam Integer pageNum, @RequestParam Integer size) {
        return new RespJson(200, "OK", postService.getPost(pageNum, size));
    }
}
