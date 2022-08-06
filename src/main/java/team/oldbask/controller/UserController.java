package team.oldbask.controller;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.oldbask.apiException.EmBusinessError;
import team.oldbask.apiException.TransactionException;
import team.oldbask.domain.form.*;
import team.oldbask.server.DiseaseService;
import team.oldbask.server.HealthService;
import team.oldbask.server.PersonalTasteService;
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
    private PersonalTasteService personalTasteService;

    @Autowired
    private HealthService healthService;

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
    public RespJson loginByWechat(@RequestParam(value = "code") String code, @NotNull HttpServletRequest request) throws TransactionException {
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
    public RespJson registerByWechat(@RequestBody UserForm userPostForm, @NotNull HttpServletRequest request) throws TransactionException {
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
    public RespJson submitDisease(@RequestBody DiseaseForm diseasePostForm, @NotNull HttpServletRequest request) {
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

    @Contract("_ -> new")
    @ResponseBody
    @GetMapping("/getDisease")
    private @NotNull RespJson getDisease(@NotNull HttpServletRequest request) {
        String uid = (String)request.getSession().getAttribute("id");
        log.info("getDisease-200-OK");
        return new RespJson(200, "OK", diseaseService.getDisease(uid));
    }

    @ResponseBody
    @PostMapping("/submitPersonalTaste")
    public RespJson submitPersonalTaste(@RequestBody PersonalTasteForm personalTastePostForm, @NotNull HttpServletRequest request) {
        String uid = (String)request.getSession().getAttribute("id");
        if (personalTasteService.submitPersonalTaste(personalTastePostForm, uid)) {
            log.info("submitPersonalTaste-200-OK");
            return new RespJson(200, "OK");
        } else {
            log.info("submitPersonalTaste-" + EmBusinessError.USER_NOT_EXIST.getErrorCode()
                    + "-" + EmBusinessError.USER_NOT_EXIST.getErrorMsg());
            return new RespJson(EmBusinessError.USER_NOT_EXIST.getErrorCode(),
                    EmBusinessError.USER_NOT_EXIST.getErrorMsg());
        }
    }

    @ResponseBody
    @GetMapping("/getPersonalTaste")
    public RespJson getPersonalTaste(@NotNull HttpServletRequest request) {
        String uid = (String)request.getSession().getAttribute("id");
        log.info("getPersonalTaste-200-OK");
        return new RespJson(200, "OK", personalTasteService.getPersonalTaste(uid));
    }

    @ResponseBody
    @PostMapping("/submitHealth")
    public RespJson submitHealth(@RequestBody HealthForm healthPostForm, @NotNull HttpServletRequest request) {
        String uid = (String)request.getSession().getAttribute("id");
        if (healthService.submitHealth(healthPostForm, uid)) {
            log.info("submitHealth-200-OK");
            return new RespJson(200, "OK");
        } else {
            log.info("submitHealth-" + EmBusinessError.USER_NOT_EXIST.getErrorCode()
                    + "-" + EmBusinessError.USER_NOT_EXIST.getErrorMsg());
            return new RespJson(EmBusinessError.USER_NOT_EXIST.getErrorCode(),
                    EmBusinessError.USER_NOT_EXIST.getErrorMsg());
        }
    }

    @ResponseBody
    @GetMapping("/getHealth")
    public RespJson getHealth(@NotNull HttpServletRequest request) {
        String uid = (String)request.getSession().getAttribute("id");
        log.info("getHealth-200-OK");
        return new RespJson(200, "OK", healthService.getHealth(uid));
    }

    @ResponseBody
    @GetMapping("/info")
    public RespJson getUserInfo(@NotNull HttpServletRequest request) {
        String uid = (String)request.getSession().getAttribute("id");
        log.info("info-200-OK");
        return new RespJson(200, "OK", userService.getUserInfo(uid));
    }

    @ResponseBody
    @PostMapping("/submitInfo")
    public RespJson submitUserInfo(@RequestBody UserInfoForm userInfoForm, @NotNull HttpServletRequest request) {
        String uid = (String)request.getSession().getAttribute("id");
        userService.submitUserInfo(userInfoForm, uid);
        log.info("submitInfo-200-OK");
        return new RespJson(200, "OK");
    }

    @ResponseBody
    @GetMapping("/login")
    public RespJson login(@RequestParam String uid, @NotNull HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("id", uid);
        redisTemplate.opsForValue().set("id:" + uid, session.getId());
        log.info("login-200-OK");
        return new RespJson(200, "OK");
    }
}
