package com.lingfeng.camundastudy.common.type.handle.global;

import com.lingfeng.camundastudy.common.util.EncryptUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 敏感数据加密处理器
 */
public class EncryptTypeHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        // 【入库前加密】
        // MyBatis 准备把数据塞给数据库时，我们截获它，进行加密
        String encrypted = EncryptUtil.encrypt(parameter);
        ps.setString(i, encrypted);
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // 【出库后解密】
        // MyBatis 从数据库读到数据后，我们截获它，进行解密
        String encrypted = rs.getString(columnName);
        return EncryptUtil.decrypt(encrypted);
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String encrypted = rs.getString(columnIndex);
        return EncryptUtil.decrypt(encrypted);
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String encrypted = cs.getString(columnIndex);
        return EncryptUtil.decrypt(encrypted);
    }
}