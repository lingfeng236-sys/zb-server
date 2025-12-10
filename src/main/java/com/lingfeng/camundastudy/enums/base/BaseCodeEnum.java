package com.lingfeng.camundastudy.enums.base;

/**
 * 通用枚举接口
 * 所有需要存入数据库的枚举都要实现这个接口
 */
public interface BaseCodeEnum {
    // 获取存入数据库的值（这里假设是 Integer，也可以是 String）
    Integer getCode();
    // 获取枚举的描述
    String getDesc();
}