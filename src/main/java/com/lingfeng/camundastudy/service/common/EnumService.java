package com.lingfeng.camundastudy.service.common;

import com.lingfeng.camundastudy.domain.common.DictDto;
import com.lingfeng.camundastudy.enums.base.BaseCodeEnum;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EnumService {

    // 缓存：Map<枚举类简名, 枚举Class>，例如 "GenderEnum" -> GenderEnum.class
    private final Map<String, Class<? extends BaseCodeEnum>> enumCache = new ConcurrentHashMap<>();

    // 指定要扫描的枚举包路径
    private static final String ENUM_PACKAGE = "com.lingfeng.camundastudy.enums";

    /**
     * 驼峰转下划线正则
     */
    private static final Pattern CAMEL_TO_SNAKE_PATTERN = Pattern.compile("([a-z])([A-Z]+)");

    /**
     * 项目启动时自动扫描并缓存所有 BaseCodeEnum 的实现类
     */
    @PostConstruct
    public void init() {
        try {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resolver);

            // 扫描 enums 包及其子包下的所有 .class 文件
            String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                    ClassUtils.convertClassNameToResourcePath(ENUM_PACKAGE) + "/**/*.class";

            Resource[] resources = resolver.getResources(packageSearchPath);

            for (Resource resource : resources) {
                if (resource.isReadable()) {
                    MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
                    String className = metadataReader.getClassMetadata().getClassName();

                    try {
                        Class<?> clazz = Class.forName(className);
                        // 判断是否是枚举，且实现了 BaseCodeEnum 接口
                        if (clazz.isEnum() && BaseCodeEnum.class.isAssignableFrom(clazz)) {
                            String dictKey = generateDictKey(clazz.getSimpleName());
                            enumCache.put(dictKey, (Class<? extends BaseCodeEnum>) clazz);
                            log.debug("已加载字典枚举: {}", clazz.getSimpleName());
                        }
                    } catch (ClassNotFoundException e) {
                        log.warn("加载类失败: {}", className);
                    }
                }
            }
            log.info("枚举字典加载完成，共加载 {} 个枚举类", enumCache.size());
        } catch (Exception e) {
            log.error("初始化枚举字典失败", e);
        }
    }

    /**
     * 核心逻辑：类名 -> 字典Type
     * 规则：去除 Enum 后缀 + 驼峰转下划线
     */
    private String generateDictKey(String className) {
        // 1. 去除 "Enum" 后缀
        if (className.endsWith("Enum")) {
            className = className.substring(0, className.length() - 4);
        }
        // 2. 驼峰转下划线 (e.g. ApprovalStatus -> approval_status)
        Matcher matcher = CAMEL_TO_SNAKE_PATTERN.matcher(className);
        String snakeCase = matcher.replaceAll("$1_$2").toLowerCase();
        return snakeCase;
    }

    /**
     * 根据枚举类名获取字典列表
     *
     * @param dictType 枚举类名 (e.g., "GenderEnum", "ApprovalStatus")
     * @return List<DictDto>
     */
    public List<DictDto> obtainByDictType(String dictType) {
        Class<? extends BaseCodeEnum> enumClass = enumCache.get(dictType);
        if (enumClass == null) {
            return Collections.emptyList();
        }

        // 获取该枚举的所有实例
        BaseCodeEnum[] constants = enumClass.getEnumConstants();
        if (constants == null) {
            return Collections.emptyList();
        }

        // 转换为 DictDto 列表
        return Arrays.stream(constants)
                .map(baseCodeEnum -> DictDto.builder().code(baseCodeEnum.getCode()).desc(baseCodeEnum.getDesc()).build())
                .collect(Collectors.toList());
    }
}