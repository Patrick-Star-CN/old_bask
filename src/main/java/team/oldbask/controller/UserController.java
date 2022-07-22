package team.oldbask.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.oldbask.apiException.EmBusinessError;
import team.oldbask.apiException.TransactionException;
import team.oldbask.domain.DiseasePostForm;
import team.oldbask.domain.UserInfoForm;
import team.oldbask.domain.UserPostForm;
import team.oldbask.server.DiseaseService;
import team.oldbask.server.UserService;
import team.oldbask.util.RespJson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiseaseService diseaseService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 微信登录接口
     * @param code 参数形式传入的用户code
     * @return json数据，包含状态码和状态信息
     * @throws TransactionException openid错误
     */
    @ResponseBody
    @GetMapping("/wechat/login")
    public RespJson loginByWechat(@RequestParam(value = "code") String code, HttpServletRequest request) throws TransactionException {
        HttpSession session = request.getSession();
        Integer uid = userService.loginByWechat(code);
        if (uid != null) {
            session.setAttribute("id", uid.toString());
            redisTemplate.opsForValue().set("id:" + uid, session.getId());
            log.info("login-200-OK");
            return new RespJson(200, "OK");
        } else {
            log.info("login-" + EmBusinessError.USER_NOT_EXIST.getErrorCode()
                     + "-" + EmBusinessError.USER_NOT_EXIST.getErrorMsg());
            return new RespJson(EmBusinessError.USER_NOT_EXIST.getErrorCode(),
                                EmBusinessError.USER_NOT_EXIST.getErrorMsg());
        }
    }

    @ResponseBody
    @PostMapping("/wechat/register")
    public RespJson registerByWechat(@RequestBody UserPostForm userPostForm, HttpServletRequest request) throws TransactionException {
        HttpSession session = request.getSession();
        Integer uid = userService.registerByWechat(userPostForm);
        if (uid != null) {
            session.setAttribute("id", uid.toString());
            redisTemplate.opsForValue().set("id:" + uid, session.getId());
            log.info("register-200-OK");
            return new RespJson(200, "OK");
        } else {
            log.info("register-" + EmBusinessError.USER_EXIST.getErrorCode()
                    + "-" + EmBusinessError.USER_EXIST.getErrorMsg());
            return new RespJson(EmBusinessError.USER_EXIST.getErrorCode(),
                                EmBusinessError.USER_EXIST.getErrorMsg());
        }
    }

    @ResponseBody
    @PostMapping("/submitDisease")
    public RespJson submitDisease(@RequestBody DiseasePostForm diseasePostForm, HttpServletRequest request) {
        String uid = (String)request.getSession().getAttribute("id");
        if (diseaseService.submitDisease(diseasePostForm, uid)) {
            log.info("submitDisease-200-OK");
            return new RespJson(200, "OK");
        } else {
            log.info("submitDisease-" + EmBusinessError.USER_NOT_EXIST.getErrorCode()
                     + "-" + EmBusinessError.USER_NOT_EXIST.getErrorMsg());
            return new RespJson(EmBusinessError.USER_NOT_EXIST.getErrorCode(),
                                EmBusinessError.USER_NOT_EXIST.getErrorMsg());
        }
    }

    @ResponseBody
    @GetMapping("/info")
    public RespJson getUserInfo(HttpServletRequest request) {
        String uid = (String)request.getSession().getAttribute("id");
        log.info("info-200-OK");
        return new RespJson(200, "OK", userService.getUserInfo(uid));
    }

    @ResponseBody
    @PostMapping("/submitInfo")
    public RespJson submitUserInfo(@RequestBody UserInfoForm userInfoForm, HttpServletRequest request) {
        String uid = (String)request.getSession().getAttribute("id");
        userService.submitUserInfo(userInfoForm, uid);
        log.info("submitInfo-200-OK");
        return new RespJson(200, "OK");
    }
}
