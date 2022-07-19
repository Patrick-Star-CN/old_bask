package team.oldbask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.oldbask.apiException.EmBusinessError;
import team.oldbask.apiException.TransactionException;
import team.oldbask.domain.UserPostForm;
import team.oldbask.server.UserService;
import team.oldbask.util.RespJson;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 微信登录接口
     * @param code 参数形式传入的用户code
     * @return json数据，包含状态码和状态信息
     * @throws TransactionException openid错误
     */
    @ResponseBody
    @GetMapping("/wechat/login")
    public RespJson loginByWechat(@RequestParam(value = "code") String code) throws TransactionException {
        RespJson respJson = new RespJson();
        if (userService.loginByWechat(code)) {
            respJson.setCode(200);
            respJson.setMsg("OK");
        } else {
            respJson.setCode(EmBusinessError.USER_NOT_EXIST.getErrorCode());
            respJson.setMsg(EmBusinessError.USER_NOT_EXIST.getErrorMsg());
        }
        respJson.setData(null);
        return respJson;
    }

    @ResponseBody
    @PostMapping("/wechat/register")
    public RespJson registerByWechat(@RequestBody UserPostForm userPostForm) throws TransactionException {
        RespJson respJson = new RespJson();
        if (userService.registerByWechat(userPostForm)) {
            respJson.setCode(200);
            respJson.setMsg("OK");
        } else {
            respJson.setCode(EmBusinessError.USER_EXIST.getErrorCode());
            respJson.setMsg(EmBusinessError.USER_EXIST.getErrorMsg());
        }
        respJson.setData(null);
        return respJson;
    }

}
