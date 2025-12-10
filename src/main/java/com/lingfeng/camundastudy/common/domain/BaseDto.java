package com.lingfeng.camundastudy.common.domain;

import com.alibaba.fastjson2.annotation.JSONField;
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

    @JSONField(format = DateUtil.CT_DS)
    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "变更人")
    private String updateBy;

    @Schema(description = "修改人ID")
    private Long updateById;

    @JSONField(format = DateUtil.CT_DS)
    @Schema(description = "变更时间")
    private Date updateTime;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "删除标志")
    private String delFlag;
}
