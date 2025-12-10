package com.lingfeng.camundastudy.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis-Plus 配置类
 * 
 * @author lingfeng
 */
@Configuration
@MapperScan("com.lingfeng.camundastudy.dao.mapper")
public class MybatisPlusConfig {
    // MyBatis-Plus 会自动配置，这里只需要指定 Mapper 扫描路径
}
