package com.lingfeng.camundastudy.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.lingfeng.camundastudy.common.domain.NewBaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * SPU管理对象 pd_spu
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "pd_spu")
@Schema(description = "SPU表")
public class PdSpu extends NewBaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    @Schema(description = "SPU名称")
    private String spuName;

    @Schema(description = "SPU 业务code")
    private String spuCode;

    @Schema(description = "品类")
    private Integer category;

    @Schema(description = "包装规格")
    private Integer packagingSpecification;

    @Schema(description = "产品线（国家商品名）")
    private Integer productLine;

    @Schema(description = "产品型号")
    private Integer productModel;


    @Schema(description = "主图")
    private String imgUrl;

    @Schema(description = "雾化平台")
    private Integer atomizationPlatform;

    @Schema(description = "电池容量")
    private Integer batteryCapacity;


    @Schema(description = "Prefilled Pod产品名内部描述")
    private String podProductInnerDesc;

    @Schema(description = "换弹式结构描述")
    private String kitStructureDesc;

    @Schema(description = "Pod使用方式描述")
    private String podUseDesc;

    @Schema(description = "Open不注油产品描述")
    private String openProductDesc;

    @Schema(description = "Prefilled Pod设计容量梯度")
    private Integer prefilledCapacityGradient;

    @Schema(description = "Open不注油Pod容量梯度")
    private Integer nonOilCapacityGradient;

    @Schema(description = "一次性Vape设计容量梯度")
    private Integer disposableCapacityGradient;

    @Schema(description = "瓶装油设计容量类型")
    private Integer bottledOilCapacity;

    @Schema(description = "功率调整方式")
    private Integer powerAdjustmentMethod;

    @Schema(description = "抽吸方式")
    private Integer suctionMethod;

    @Schema(description = "吸阻调整方式")
    private Integer suctionAdjustmentMethod;

    @Schema(description = "TPM")
    private String tpm;

    @Schema(description = "满电口数-高功率")
    private String fullyChargedPorts;

    @Schema(description = "CMF工艺（品质纬度）")
    private String cmfProcess;

    @Schema(description = "组装供应商类型")
    private Integer assemblySupplierType;

    @Schema(description = "烟嘴设计寿命")
    private Integer cigaretteHolderDesignLife;

    @Schema(description = "Device设计寿命")
    private Integer deviceDesignLife;

    @Schema(description = "Pod设计寿命")
    private Integer podDesignLife;

    @Schema(description = "品类偏好")
    private Integer categoryPreference;

    @Schema(description = "用量偏好")
    private Integer usagePreference;

    @Schema(description = "尼古丁摄入偏好")
    private Integer nicotineIntakePreference;

    @Schema(description = "口感偏好")
    private Integer tastePreference;

    @Schema(description = "吸阻偏好")
    private Integer suctionPreference;

    @Schema(description = "价敏偏好")
    private Integer pricePreference;

    @Schema(description = "购买习惯偏好")
    private Integer purchasingPreference;

    @Schema(description = "付费意愿偏好")
    private Integer willingnessPayPreference;

    @Schema(description = "SPU的合规性吻合类型（多选）")
    private String spuComplianceMatchingType;

    @Schema(description = "TVS需求")
    private Integer tvsDemand;

    @Schema(description = "弹&瓶出货方式")
    private Integer podActivationStatus;

    @Schema(description = "杆&弹出货方式")
    private Integer devicePodDeliveryMethod;

    @Schema(description = "是否为外购SPU")
    private Integer outsourcedSpu;

    @Schema(description = "电芯型号")
    private Integer cellModel;

    @Schema(description = "CMF是否自研")
    private Integer cmfIsSelf;
}

