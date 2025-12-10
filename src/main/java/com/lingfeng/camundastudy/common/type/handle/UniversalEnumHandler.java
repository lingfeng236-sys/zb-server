package com.lingfeng.camundastudy.common.type.handle;

import com.lingfeng.camundastudy.enums.base.BaseCodeEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;

/**
 * 通用枚举处理器
 * E 代表具体的枚举类，它必须同时继承 Enum 并且实现 BaseCodeEnum 接口
 */
public class UniversalEnumHandler<E extends Enum<E> & BaseCodeEnum> extends BaseTypeHandler<E> {

    private final Class<E> type;

    // MyBatis 在初始化时会调用这个构造函数，把具体的枚举类型传进来
    public UniversalEnumHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        // 核心：调用接口方法获取 code，存入数据库
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // 获取数据库里的值
        int code = rs.getInt(columnName);
        // 处理数据库为 NULL 的情况 (rs.wasNull() 检查最后读取的列是否为 null)
        return rs.wasNull() ? null : getEnumByCode(code);
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int code = rs.getInt(columnIndex);
        return rs.wasNull() ? null : getEnumByCode(code);
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int code = cs.getInt(columnIndex);
        return cs.wasNull() ? null : getEnumByCode(code);
    }

    /**
     * 辅助方法：通过 code 查找对应的枚举
     */
    private E getEnumByCode(int code) {
        // type.getEnumConstants() 返回该枚举的所有实例
        return Arrays.stream(type.getEnumConstants())
                .filter(e -> Objects.equals(e.getCode(), code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown code: " + code + " for enum " + type.getSimpleName()));
    }
}