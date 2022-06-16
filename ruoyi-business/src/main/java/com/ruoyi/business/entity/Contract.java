package com.ruoyi.business.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author xw
 * @since 2021-10-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("z_contract")
public class Contract extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 合同编号
     */
    @TableField("htbh")
    @ApiModelProperty("合同编号")
    private String htbh;

    /**
     * 合同名称
     */
    @TableField("htmc")
    @ApiModelProperty("合同名称")
    private String htmc;

    /**
     * 合同日期
     */
    @TableField("qdrq")
    @ApiModelProperty(value = "合同日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date qdrq;

    /**
     * 对方合同号
     */
    @TableField("dfhth")
    @ApiModelProperty("对方合同号")
    private String dfhth;

    /**
     * 是否挂靠
     */
    @TableField("sfgk")
    @ApiModelProperty("是否挂靠")
    private Integer sfgk;

    /**
     * 合同文本
     */
    @TableField("htwb")
    @ApiModelProperty("合同文本")
    private Integer htwb;

    /**
     * 总金额
     */
    @TableField("zje")
    @ApiModelProperty("总金额")
    private Double zje;

    /**
     * 审计金额
     */
    @TableField("sjje")
    @ApiModelProperty("审计金额")
    private Double sjje;

    /**
     * 税率
     */
    @TableField("sl")
    @ApiModelProperty("税率")
    private Float sl;

    /**
     * 地区
     */
    @TableField("dq")
    @ApiModelProperty("地区")
    private String dq;

    /**
     * 负责人
     */
    @TableField("fzr")
    @ApiModelProperty("负责人")
    private String fzr;

    /**
     * 申请人
     */
    @TableField("sqr")
    @ApiModelProperty("申请人")
    private String sqr;

    /**
     * 状态
     */
    @TableField("zt")
    @ApiModelProperty("状态")
    private Integer zt;

    /**
     * 附件
     */
    @TableField("fj")
    @ApiModelProperty("附件")
    private String fj;

    /**
     * 收款周期 0:一次性 1:每个月 2:自定义
     */
    @TableField("skzq")
    @ApiModelProperty("收款周期 0:一次性 1:每个月 2:自定义")
    private Integer skzq;


}
