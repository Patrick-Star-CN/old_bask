package team.oldbask.apiException;

/**
 * 自定义API异常类
 * @author Patrick_Star
 * @version 1.0
 */
public class TransactionException extends Exception implements CommonError {

    /**
     * 序列化
     */
    private static final long serialVersionUID = -4586789845574329434L;
    private CommonError commonError;

    /**
     * 直接接受EmBusinessError的传参用于构造业务异常
     * @param commonError EmBusinessError的一个具体异常
     */
    public TransactionException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    /**
     * 接收自定义errMsg的方法构造业务异常
     * @param commonError 一个新的基础自定义API异常
     * @param errMsg 异常消息
     */
    public TransactionException(CommonError commonError, String errMsg) {
        super();
        this.commonError = commonError;
        this.commonError.setErrorMsg(errMsg);
    }

    @Override
    public int getErrorCode() {
        return this.commonError.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return this.commonError.getErrorMsg();
    }

    @Override
    public CommonError setErrorMsg(String errorMsg) {
        this.commonError.setErrorMsg(errorMsg);
        return this;
    }
}