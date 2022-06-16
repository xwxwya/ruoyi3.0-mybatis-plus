package com.ruoyi.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.business.entity.Contract;
import com.ruoyi.common.mybatisPlus.MyBaseMapper;

import java.util.List;

/**
 * @author xw
 * @version 1.0
 * @date 2021/11/1 16:02
 */
public interface ContractMapper extends MyBaseMapper<Contract> {

    List<Contract> getAll();
}
