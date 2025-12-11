package com.lingfeng.camundastudy.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lingfeng.camundastudy.common.domain.BaseEntity;
import com.lingfeng.camundastudy.enums.ApprovalStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "zb_leave_record", autoResultMap = true)
public class LeaveRecordEntity extends BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String applicant;

    private Integer days;

    private ApprovalStatus status;

}
