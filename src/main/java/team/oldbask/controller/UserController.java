package team.oldbask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.oldbask.domain.UserPostForm;
import team.oldbask.server.UserService;
import team.oldbask.util.RespJson;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/wechat/login")
    public RespJson loginByWechat(@RequestBody UserPostForm userPostForm) {
        RespJson respJson = new RespJson();
        if (userService.loginByWechat(userPostForm)) {
            respJson.setCode(200);
            respJson.setMsg("OK");
            respJson.setData(null);
        }
        return respJson;
    }
}
