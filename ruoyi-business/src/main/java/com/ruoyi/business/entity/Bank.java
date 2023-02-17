package com.ruoyi.business.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 问题集
 * </p>
 *
 * @author xw
 * @since 2023-02-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("y_bank")
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("answer")
    private String answer;

    @TableField("question")
    private String question;

    @TableField("indexes")
    private String indexes;


}
