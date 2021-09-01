package cn.gson.his.common;

import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class LoginConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration=registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns("/**");
        registration.excludePathPatterns(
                "/login"
        );
    }
}
