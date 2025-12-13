package com.lingfeng.camundastudy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class CamundaStudyApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void generatePassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // 生成加密后的字符串，存入数据库的 password 字段
        System.out.println(encoder.encode("123456"));
        // 输出类似：$2a$10$X/hX... (每次运行结果都不一样，都是对的)
    }

}
