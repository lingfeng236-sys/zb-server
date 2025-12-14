package com.lingfeng.camundastudy.config;

import com.lingfeng.camundastudy.config.converter.BaseCodeEnumConverterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web MVC 配置
 * 
 * @author lingfeng
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 添加自定义转换器
     * 用于处理 URL 参数、@RequestParam、@ModelAttribute 等场景下的类型转换
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        // 注册通用枚举转换器工厂
        registry.addConverterFactory(new BaseCodeEnumConverterFactory());
    }
}
