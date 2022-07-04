package com.ruoyi.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.business.entity.Contract;
import com.ruoyi.business.mapper.ContractMapper;
import com.ruoyi.business.service.ContractService;
import com.ruoyi.common.mybatisPlus.MyBaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xw
 * @version 1.0
 * @date 2022/3/31 16:31
 */
@Service
public class ContractServiceImpl extends MyBaseServiceImpl<ContractMapper, Contract> implements ContractService {

    @Resource
    private ContractMapper mapper;

    @Override
    public List<Contract> example() {
        QueryWrapper<Contract> qw = new QueryWrapper<>();
        qw.eq("htbh","2039");
//        qw.like("htbh","2039");
//        qw.notLike("htbh","2039");
//        qw.between("htbh",1,2);
        qw.orderByDesc("qdrq","htbh");
        return mapper.selectList(qw);
    }
}
