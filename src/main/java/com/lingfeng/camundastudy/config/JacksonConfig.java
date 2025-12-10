package com.lingfeng.camundastudy.config;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.util.JSONObject1O;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.lingfeng.camundastudy.common.deserializer.UniversalEnumDeserializer;
import com.lingfeng.camundastudy.enums.base.BaseCodeEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class JacksonConfig {

    /**
     * Spring Boot 会自动扫描并注册所有类型为 Module 的 Bean 到 ObjectMapper 中
     */
    @Bean
    public Module baseEnumModule() {
        SimpleModule module = new SimpleModule();

        // 1. 处理反序列化 (JSON -> Enum)
        module.setDeserializers(new SimpleDeserializers() {
            @Override
            public JsonDeserializer<?> findEnumDeserializer(Class<?> type, DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
                if (BaseCodeEnum.class.isAssignableFrom(type)) {
                    return new UniversalEnumDeserializer((Class<? extends BaseCodeEnum>) type);
                }
                return super.findEnumDeserializer(type, config, beanDesc);
            }
        });

        // 2. 处理序列化 (Enum -> JSON)
        module.addSerializer(BaseCodeEnum.class, new JsonSerializer<BaseCodeEnum>() {
            @Override
            public void serialize(BaseCodeEnum value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                String jsonString = JSONObject.toJSONString(value);
                // 统一写出 code 值
                gen.writeNumber(jsonString);
            }
        });

        return module;
    }
}