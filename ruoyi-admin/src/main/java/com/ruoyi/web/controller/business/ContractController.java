package com.ruoyi.web.controller.business;

import com.ruoyi.business.entity.Contract;
import com.ruoyi.business.mapper.ContractMapper;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.mapper.SysConfigMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xw
 * @version 1.0
 * @date 2021/10/15 10:30
 */
@RestController
@RequestMapping("/business/contract")
public class ContractController {

    @Resource
    private ContractMapper mapper;

    @Resource
    private SysConfigMapper sysConfigMapper;

    @GetMapping("/get")
    public AjaxResult get(){
        List<Contract> all = mapper.getAll();
        return AjaxResult.success(all);
    }
}
