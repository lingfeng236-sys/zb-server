package com.lingfeng.camundastudy.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lingfeng.camundastudy.common.domain.NewBaseEntity;
import com.lingfeng.camundastudy.common.type.handle.EncryptTypeHandler;
import com.lingfeng.camundastudy.enums.user.GenderEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_user", autoResultMap = true)
public class UserEntity extends NewBaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    // 实际项目中该字段通常不直接返回给前端，可以使用 @JsonIgnore
    @TableField(typeHandler = EncryptTypeHandler.class)
    private String password;

    private String nickname;

    private String email;

    private GenderEnum gender;
}