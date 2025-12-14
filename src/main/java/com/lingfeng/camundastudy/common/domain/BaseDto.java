package com.lingfeng.camundastudy.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lingfeng.camundastudy.common.util.DateUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class BaseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "创建人")
    private String createBy;

    @Schema(description = "创建人ID")
    private Long createById;

    @JsonFormat(pattern = DateUtil.CT_DS, timezone = "GMT+8")
    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "变更人")
    private String updateBy;

    @Schema(description = "修改人ID")
    private Long updateById;

    @JsonFormat(pattern = DateUtil.CT_DS, timezone = "GMT+8")
    @Schema(description = "变更时间")
    private Date updateTime;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "删除标志")
    private String delFlag;
}
