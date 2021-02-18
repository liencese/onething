package com.linewell.gg.conf;

import com.linewell.gg.interceptor.PUserInterceptor;
import com.linewell.gg.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器
 *
 * @author lenovo
 * @version 1.0
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/qjxz", "guide", "/sbqd", "/ybtx", "/add_moduleInstance", "/clsc", "/saveAttrStartUp", "/sbgz", "/uploadfile", "/delFile", "/uploadPic");
        registry.addInterceptor(new PUserInterceptor()).addPathPatterns("/module_config", "/get_module", "/module_edit",
                "/save_moduleConfig", "/delete_moduleConfig", "/service_config",
                "/get_serviceConfig", "/service_chose", "/get_servicebync", "/save_serviceConfig", "/material_config",
                "/get_materialConfig", "/save_materialConfig", "/delete_materialConfig", "/situation_config",
                "/save_situationConfig", "/update_situationConfig", "/get_situationConfig", "/delete_situationConfig", "/get_moduleServicesMaterials");

    }
}
