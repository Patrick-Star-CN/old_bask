package team.oldbask.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import team.oldbask.apiException.EmBusinessError;
import team.oldbask.apiException.TransactionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Component
public class RedisSessionInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws TransactionException {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("id") != null) {
            String loginSessionId = redisTemplate.opsForValue().get("id:" + (String) session.getAttribute("id"));
            if (loginSessionId != null && loginSessionId.equals(session.getId())) {
                return true;
            }
        }
        throw new TransactionException(EmBusinessError.USER_NOT_LOGIN);
    }
}
