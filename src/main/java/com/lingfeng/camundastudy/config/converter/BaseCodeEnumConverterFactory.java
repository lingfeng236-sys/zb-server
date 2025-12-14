package com.lingfeng.camundastudy.config.converter;

import com.lingfeng.camundastudy.common.util.StrUtils;
import com.lingfeng.camundastudy.enums.base.BaseCodeEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.util.Arrays;
import java.util.Objects;

/**
 * 通用枚举转换工厂
 * 用于处理 URL 参数、@RequestParam、@ModelAttribute 等场景下的枚举转换
 * 
 * @author lingfeng
 */
public class BaseCodeEnumConverterFactory implements ConverterFactory<String, BaseCodeEnum> {

    @Override
    @SuppressWarnings("unchecked")
    public <T extends BaseCodeEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToEnumConverter<>(targetType);
    }

    /**
         * String 到枚举的转换器
         */
        private record StringToEnumConverter<T extends BaseCodeEnum>(Class<T> enumType) implements Converter<String, T> {

        @Override
            public T convert(String source) {
                // 如果传入值为空，返回 null
                if (StrUtils.isBlank(source)) {
                    return null;
                }

                // 策略 1：尝试按 Code (Integer) 匹配
                try {
                    Integer codeInt = Integer.valueOf(source.trim());
                    T match = Arrays.stream(enumType.getEnumConstants())
                            .filter(e -> Objects.equals(e.getCode(), codeInt))
                            .findFirst()
                            .orElse(null);

                    if (match != null) {
                        return match;
                    }
                } catch (NumberFormatException e) {
                    // 如果转换数字失败（比如传的是 "MALE"），忽略异常，进入下一个策略
                }

                // 策略 2：尝试按 Enum Name 匹配（支持前端传 "MALE", "FEMALE"）
                for (T enumConstant : enumType.getEnumConstants()) {
                    // 强转回 Enum 类型以访问 name() 方法
                    if (((Enum<?>) enumConstant).name().equalsIgnoreCase(source.trim())) {
                        return enumConstant;
                    }
                }

                // 如果都没匹配上，抛出异常
                throw new IllegalArgumentException(
                        String.format("无法将值 '%s' 转换为枚举 %s。请传入有效的 code 值或枚举名称",
                                source, enumType.getSimpleName())
                );
            }
        }
}
