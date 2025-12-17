package com.lingfeng.camundastudy.domain.dto.user;

import com.lingfeng.camundastudy.enums.ApprovalStatus;
import lombok.Data;

@Data
public class LeaveRecordDto {

    private Long id;

    private String applicant;

    private Integer days;

    private ApprovalStatus status;

}
