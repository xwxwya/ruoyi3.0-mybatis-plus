package com.ruoyi.web.controller.business;


import com.ruoyi.business.entity.Bank;
import com.ruoyi.business.service.IBankService;
import com.ruoyi.common.core.controller.BusinessCommonController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 问题集 前端控制器
 * </p>
 *
 * @author xw
 * @since 2023-02-17
 */
@RestController
@RequestMapping("/business/bank")
public class BankController extends BusinessCommonController<IBankService,Bank> {

    @Resource
    private IBankService service;

    @Override
    public IBankService getService() {
        return service;
    }
}
