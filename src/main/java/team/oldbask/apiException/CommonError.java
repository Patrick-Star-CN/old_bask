package team.oldbask.apiException;

/**
 * 基础自定义API异常接口
 * @author Patrick_Star
 * @version 1.0
 */
public interface CommonError {
    /**
     * 获取异常编码
     * @return 异常编码
     */
    int getErrorCode();

    /**
     * 获取异常消息
     * @return 异常消息
     */
    String getErrorMsg();

    /**
     * 利用异常消息设置自定义API异常
     * @param ErrorMsg 异常消息
     * @return 自定义API异常
     */
    CommonError setErrorMsg(String ErrorMsg);
}
