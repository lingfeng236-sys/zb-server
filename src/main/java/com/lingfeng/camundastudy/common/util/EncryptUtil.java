package com.lingfeng.camundastudy.common.util;

import java.util.Base64;
// 实际生产请引入 javax.crypto.* 库进行标准 AES 加密

public class EncryptUtil {
    
    // 模拟加密：实际项目中请替换为真实的 AES/RSA 加密逻辑
    public static String encrypt(String value) {
        if (value == null) return null;
        // 简单示例：拼上前缀 + Base64编码
        return "ENC_" + Base64.getEncoder().encodeToString(value.getBytes());
    }

    // 模拟解密
    public static String decrypt(String value) {
        if (value == null) return null;
        // 检查是否是加密数据（防止历史旧数据报错）
        if (!value.startsWith("ENC_")) return value;
        
        String cleanValue = value.substring(4); // 去掉前缀
        return new String(Base64.getDecoder().decode(cleanValue));
    }
}