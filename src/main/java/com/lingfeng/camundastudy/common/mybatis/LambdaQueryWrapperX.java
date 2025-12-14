package com.lingfeng.camundastudy.common.mybatis;

import com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper;
import com.baomidou.mybatisplus.core.conditions.SharedString;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.lingfeng.camundastudy.common.util.CollectionUtils;
import com.lingfeng.camundastudy.common.util.StrUtils;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * <p>
 * MyBatis-Plus 查询包装器拓展 {@link LambdaQueryWrapper}
 * </p>
 * 增加部分扩展方法，条件值为空时不要拼接到条件中
 */
public class LambdaQueryWrapperX<T> extends AbstractLambdaWrapper<T, LambdaQueryWrapperX<T>> implements Query<LambdaQueryWrapperX<T>, T, SFunction<T, ?>> {

    /** 查询字段 */
    private SharedString sqlSelect = new SharedString();

    public LambdaQueryWrapperX() {
        this((T) null);
    }

    public LambdaQueryWrapperX(T entity) {
        super.setEntity(entity);
        super.initNeed();
    }

    public LambdaQueryWrapperX(Class<T> entityClass) {
        super.setEntityClass(entityClass);
        super.initNeed();
    }

    LambdaQueryWrapperX(T entity, Class<T> entityClass, SharedString sqlSelect, AtomicInteger paramNameSeq, Map<String, Object> paramNameValuePairs, MergeSegments mergeSegments, SharedString lastSql, SharedString sqlComment, SharedString sqlFirst) {
        super.setEntity(entity);
        super.setEntityClass(entityClass);
        this.paramNameSeq = paramNameSeq;
        this.paramNameValuePairs = paramNameValuePairs;
        this.expression = mergeSegments;
        this.sqlSelect = sqlSelect;
        this.lastSql = lastSql;
        this.sqlComment = sqlComment;
        this.sqlFirst = sqlFirst;
    }

    /**
     * SELECT 部分 SQL 设置
     *
     * @param columns 查询字段
     */
    @SafeVarargs
    @Override
    public final LambdaQueryWrapperX<T> select(SFunction<T, ?>... columns) {
        if (CollectionUtils.isNotEmpty(columns)) {
            this.sqlSelect.setStringValue(columnsToString(false, columns));
        }
        return typedThis;
    }

    @Override
    public LambdaQueryWrapperX<T> select(boolean condition, List<SFunction<T, ?>> columns) {
        if (condition) {
            this.sqlSelect.setStringValue(columnsToString(false, columns));
        }
        return typedThis;
    }

    /**
     * 过滤查询的字段信息(主键除外!)
     * <p>例1: 只要 java 字段名以 "test" 开头的             -> select(i -&gt; i.getProperty().startsWith("test"))</p>
     * <p>例2: 只要 java 字段属性是 CharSequence 类型的     -> select(TableFieldInfo::isCharSequence)</p>
     * <p>例3: 只要 java 字段没有填充策略的                 -> select(i -&gt; i.getFieldFill() == FieldFill.DEFAULT)</p>
     * <p>例4: 要全部字段                                 -> select(i -&gt; true)</p>
     * <p>例5: 只要主键字段                               -> select(i -&gt; false)</p>
     *
     * @param predicate 过滤方式
     * @return this
     */
    @Override
    public LambdaQueryWrapperX<T> select(Class<T> entityClass, Predicate<TableFieldInfo> predicate) {
        if (entityClass == null) {
            entityClass = getEntityClass();
        } else {
            setEntityClass(entityClass);
        }
        Assert.notNull(entityClass, "entityClass can not be null");
        this.sqlSelect.setStringValue(TableInfoHelper.getTableInfo(entityClass).chooseSelect(predicate));
        return typedThis;
    }

    @Override
    public String getSqlSelect() {
        return sqlSelect.getStringValue();
    }

    /**
     * 用于生成嵌套 sql
     * <p>故 sqlSelect 不向下传递</p>
     */
    @Override
    protected LambdaQueryWrapperX<T> instance() {
        return new LambdaQueryWrapperX<>(getEntity(), getEntityClass(), null, paramNameSeq, paramNameValuePairs,
                new MergeSegments(), SharedString.emptyString(), SharedString.emptyString(), SharedString.emptyString());
    }

    @Override
    public void clear() {
        super.clear();
        sqlSelect.toNull();
    }

    // ===================================== 扩展方法  =========================================

    public LambdaQueryWrapperX<T> likeIfPresent(SFunction<T, ?> column, String val) {
        if (StrUtils.isNotBlank(val)) {
            return this.like(column, val);
        }
        return this;
    }

    public LambdaQueryWrapperX<T> inIfPresent(SFunction<T, ?> column, Collection<?> values) {
        List<?> params = CollectionUtils.distinct(values);
        if (CollectionUtils.isNotEmpty(params)) {
            return this.in(column, params);
        }
        return this;
    }

    public LambdaQueryWrapperX<T> inIfPresent(SFunction<T, ?> column, Object... values) {
        Object[] params = CollectionUtils.distinct(values);
        if (CollectionUtils.isNotEmpty(params)) {
            return this.in(column, params);
        }
        return this;
    }

    public LambdaQueryWrapperX<T> notInIfPresent(SFunction<T, ?> column, Collection<?> values) {
        List<?> params = CollectionUtils.distinct(values);
        if (CollectionUtils.isNotEmpty(params)) {
            return this.notIn(column, params);
        }
        return this;
    }

    public LambdaQueryWrapperX<T> notIfPresent(SFunction<T, ?> column, Collection<?> values) {
        List<?> params = CollectionUtils.distinct(values);
        if (CollectionUtils.isNotEmpty(params)) {
            return this.notIn(column, params);
        }
        return this;
    }

    public LambdaQueryWrapperX<T> eqIfPresent(SFunction<T, ?> column, Object val) {
        if (StrUtils.isNotNull(val)) {
            return this.eq(column, val);
        }
        return this;
    }

    public LambdaQueryWrapperX<T> neIfPresent(SFunction<T, ?> column, Object val) {
        if (StrUtils.isNotNull(val)) {
            return this.ne(column, val);
        }
        return this;
    }

    public LambdaQueryWrapperX<T> gtIfPresent(SFunction<T, ?> column, Object val) {
        if (StrUtils.isNotNull(val)) {
            return this.gt(column, val);
        }
        return this;
    }

    public LambdaQueryWrapperX<T> geIfPresent(SFunction<T, ?> column, Object val) {
        if (StrUtils.isNotNull(val)) {
            return this.ge(column, val);
        }
        return this;
    }

    public LambdaQueryWrapperX<T> ltIfPresent(SFunction<T, ?> column, Object val) {
        if (StrUtils.isNotNull(val)) {
            return this.lt(column, val);
        }
        return this;
    }

    public LambdaQueryWrapperX<T> leIfPresent(SFunction<T, ?> column, Object val) {
        if (StrUtils.isNotNull(val)) {
            return this.le(column, val);
        }
        return this;
    }

    public LambdaQueryWrapperX<T> betweenIfPresent(SFunction<T, ?> column, Object val1, Object val2) {
        if (StrUtils.isNotNull(val1) && StrUtils.isNotNull(val2)) {
            return this.between(column, val1, val2);
        }
        if (StrUtils.isNotNull(val1)) {
            return ge(column, val1);
        }
        if (StrUtils.isNotNull(val2)) {
            return le(column, val2);
        }
        return this;
    }

    public LambdaQueryWrapperX<T> betweenIfPresent(SFunction<T, ?> column, Object[] values) {
        Object val1 = CollectionUtils.get(values, 0);
        Object val2 = CollectionUtils.get(values, 1);
        return betweenIfPresent(column, val1, val2);
    }

    @SafeVarargs
    public final LambdaQueryWrapperX<T> selectIfPresent(SFunction<T, ?>... columns) {
        SFunction<T, ?>[] sFunctions = CollectionUtils.distinct(columns);
        if (!CollectionUtils.isEmpty(columns)) {
            return this.select(sFunctions);
        }
        return this;
    }

    public LambdaQueryWrapperX<T> applyIfPresent(String applySql) {
        if (StrUtils.isNotBlank(applySql)) {
            return this.apply(applySql);
        }
        return this;
    }

    public LambdaQueryWrapperX<T> firstIfPresent(String firstSql) {
        if (StrUtils.isNotBlank(firstSql)) {
            return this.first(firstSql);
        }
        return this;
    }

    public LambdaQueryWrapperX<T> lastIfPresent(String lastSql) {
        if (StrUtils.isNotBlank(lastSql)) {
            return this.last(lastSql);
        }
        return this;
    }

}
