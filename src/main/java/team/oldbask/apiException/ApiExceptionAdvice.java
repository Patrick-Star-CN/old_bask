package team.oldbask.apiException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import team.oldbask.util.RespJson;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@ControllerAdvice
public class ApiExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public RespJson doException(Exception ex) {
        if (ex instanceof TransactionException) {
            TransactionException businessException = (TransactionException)ex;
            return new RespJson(businessException.getErrorCode(), businessException.getErrorMsg());
        }
        else {
            return new RespJson(EmBusinessError.UNKNOWN_ERROR.getErrorCode(), EmBusinessError.UNKNOWN_ERROR.getErrorMsg());
        }
    }
}
