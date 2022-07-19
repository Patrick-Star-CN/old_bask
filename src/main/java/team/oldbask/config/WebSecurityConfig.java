package team.oldbask.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import team.oldbask.handle.RedisSessionInterceptor;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

    @Autowired
    RedisSessionInterceptor redisSessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(redisSessionInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/wechat/register")
                .excludePathPatterns("/user/wechat/login");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
