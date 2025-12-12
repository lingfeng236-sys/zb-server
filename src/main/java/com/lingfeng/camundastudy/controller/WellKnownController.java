package com.lingfeng.camundastudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Well-Known控制器，用于处理.well-known路径下的各种请求
 * 避免Chrome等浏览器请求这些路径时出现404错误
 */
@RestController
public class WellKnownController {

    /**
     * 处理Chrome DevTools相关的请求，返回空响应避免404错误
     */
    @GetMapping(".well-known/appspecific/com.chrome.devtools.json")
    @ResponseBody
    public void chromeDevTools() {
        // 返回空响应以避免404错误
    }

    /**
     * 处理通用的.well-known路径请求，返回空响应避免404错误
     */
    @GetMapping(".well-known/**")
    @ResponseBody
    public void wellKnown() {
        // 返回空响应以避免404错误
    }
}