package com.lingfeng.camundastudy.common.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        // 自动填充创建时间、更新时间
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
        
        // 自动填充删除标记，默认为 "0"
        this.strictInsertFill(metaObject, "delFlag", Integer.class, 0);
        
        // 这里的 userId 需要你从具体的上下文中获取（如 Spring Security / Sa-Token）
        // this.strictInsertFill(metaObject, "createBy", String.class, "admin"); 
        // this.strictInsertFill(metaObject, "createById", Long.class, 1L);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
        // this.strictUpdateFill(metaObject, "updateBy", String.class, "admin");
    }
}