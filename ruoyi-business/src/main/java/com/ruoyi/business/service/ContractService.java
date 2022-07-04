package com.ruoyi.business.service;

import com.ruoyi.business.entity.Contract;
import com.ruoyi.common.mybatisPlus.MyBaseService;

import java.util.List;

/**
 * @author xw
 * @version 1.0
 * @date 2022/3/31 16:30
 */
public interface ContractService extends MyBaseService<Contract> {

    List<Contract> example();
}
