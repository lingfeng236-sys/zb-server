package com.lingfeng.camundastudy.common.domain;


import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.lingfeng.camundastudy.common.util.DateUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 2024.12.01
 * 新的Entity基类，新模块建议继承此类
 * shunyang.chen
 */
@Data
public class BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    @Schema(description = "创建人")
    private String createBy;

    @TableField(value = "create_by_id", fill = FieldFill.INSERT)
    @Schema(description = "创建人ID")
    private Long createById;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JSONField(format = DateUtil.CT_DS)
    @Schema(description = "创建时间")
    private Date createTime;

    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    @Schema(description = "修改人")
    private String updateBy;

    @TableField(value = "update_by_id", fill = FieldFill.UPDATE)
    @Schema(description = "修改人ID")
    private Long updateById;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @JSONField(format = DateUtil.CT_DS)
    @Schema(description = "修改时间")
    private Date updateTime;

    @Schema(description = "备注")
    private String remark;

    @TableField(value = "del_flag", fill = FieldFill.INSERT)
    @Schema(description = "删除标志")
    private Integer delFlag;

}
