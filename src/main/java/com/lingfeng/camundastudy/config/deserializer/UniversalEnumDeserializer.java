package com.lingfeng.camundastudy.config.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.lingfeng.camundastudy.common.util.StrUtils;
import com.lingfeng.camundastudy.enums.base.BaseCodeEnum;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class UniversalEnumDeserializer extends JsonDeserializer<BaseCodeEnum<?>> {

    private final Class<? extends BaseCodeEnum<?>> enumType;

    public UniversalEnumDeserializer(Class<? extends BaseCodeEnum<?>> enumType) {
        this.enumType = enumType;
    }

    @Override
    public BaseCodeEnum<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        // 1. 读取当前 JSON 节点 (兼容 Object 和 Scalar)
        JsonNode node = p.getCodec().readTree(p);

        String source = null;

        // 2. 判断节点类型并提取核心值
        if (node.isObject()) {
            // 情况 A：处理对象形式 { "code": 1 } 或 { "code": "1" }
            if (node.has("code")) {
                JsonNode codeNode = node.get("code");
                if (!codeNode.isNull()) {
                    source = codeNode.asText();
                }
            }
        } else {
            // 情况 B：处理标量形式 1, "1", "MALE"
            source = node.asText();
        }

        // 如果提取不到值，返回 null
        if (StrUtils.isBlank(source)) {
            return null;
        }

        // 3. 开始匹配逻辑

        // --- 匹配策略 1：尝试按 Code (Integer) 匹配 ---
        // 这是原来的逻辑，优先匹配数据库存的值
        try {
            Integer codeInt = Integer.valueOf(source);
            BaseCodeEnum<?> match = Arrays.stream(enumType.getEnumConstants())
                    .filter(e -> Objects.equals(e.getCode(), codeInt))
                    .findFirst()
                    .orElse(null);

            if (match != null) {
                return match;
            }
        } catch (NumberFormatException e) {
            // 如果转换数字失败（比如传的是 "MALE"），忽略异常，进入下一个策略
        }

        // --- 匹配策略 2：尝试按 Enum Name 匹配 ---
        // 支持前端传 "MALE", "FEMALE"
        for (BaseCodeEnum<?> e : enumType.getEnumConstants()) {
            // 强转回 Enum 类型以访问 name() 方法
            if (((Enum<?>) e).name().equalsIgnoreCase(source)) {
                return e;
            }
        }

        // --- 匹配策略 3：如果都没匹配上 ---
        // 可以选择返回 null，或者抛出异常告诉前端参数错误
        // return null;
        throw new IOException("Cannot deserialize value '" + source + "' to enum " + enumType.getSimpleName());
    }
}