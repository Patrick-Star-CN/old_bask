package team.oldbask.apiException;

/**
 * 业务异常枚举类
 * @author Patrick_Star
 * @version 1.0
 */
public enum EmBusinessError implements CommonError {

    /**
     * 数据库异常
     */
    DATABASE_CONNECTION_ERROR(10001, "数据库异常"),
    /**
     * 缓存异常
     */
    REDIS_CONNECTION_ERROR(10002, "缓存异常"),
    /**
     * 服务器网络异常
     */
    NET_ERROR(10003, "服务器网络异常"),

    /**
     * 用户未登录
     */
    USER_NOT_LOGIN(20000, "用户未登录"),
    /**
     * 用户不存在
     */
    USER_NOT_EXIST(20001, "用户不存在"),
    /**
     * 用户已注册
     */
    USER_EXIST(20002, "用户已注册"),

    /**
     * 配置出错
     */
    CONFIG_ERROR(30001, "配置出错"),
    /**
     * openId异常
     */
    OPENID_ERROR(30002, "openId异常"),
    /**
     * 参数异常
     */
    PARAMETER_ERROR(30001, "参数异常"),

    /**
     * 未知错误
     */
    UNKNOWN_ERROR(40004, "未知错误")
    ;

    /**
     * 异常编码
     */
    private int errCode;
    /**
     * 异常消息
     */
    private String errMsg;

    EmBusinessError(int errCode, String errMsg ) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }


    /**
     * @see team.oldbask.apiException.CommonError#getErrorCode()
     */
    @Override
    public int getErrorCode() {
        return this.errCode;
    }

    /**
     * @see team.oldbask.apiException.CommonError#getErrorMsg()
     */
    @Override
    public String getErrorMsg() {
        return this.errMsg;
    }

    /**
     * 这个方法用于改动通用错误类型中的ErrorMsg
     * @see team.oldbask.apiException.CommonError#setErrorMsg(java.lang.String)
     */
    @Override
    public CommonError setErrorMsg(String ErrorMsg) {
        this.errMsg = ErrorMsg;
        return this;
    }

}