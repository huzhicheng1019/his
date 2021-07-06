package cn.gson.his.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter
    implements WebMvcConfigurer {
    @Configuration//跨域访问
    public class MyConfiguration {
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurerAdapter() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**");
                }
            };
        }
    }
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册TestInterceptor拦截器
//        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
//        registration.addPathPatterns("/**");//所有路径都被拦截
//        registration.excludePathPatterns(
//                //添加不拦截路径
//                "/login"//登录
//        );
//    }

    @Configuration//注册转换器
    public class WebDateConfig{
        @Autowired
        private RequestMappingHandlerAdapter handlerAdapter;
        @PostConstruct
        public void initEditableAvlidation() {
            ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer)handlerAdapter.getWebBindingInitializer();
            if(initializer.getConversionService()!=null) {
                GenericConversionService genericConversionService = (GenericConversionService)initializer.getConversionService();
                genericConversionService.addConverter(new DateConvertor());//添加自定义的类型转换器
            }
        }
    }
}
