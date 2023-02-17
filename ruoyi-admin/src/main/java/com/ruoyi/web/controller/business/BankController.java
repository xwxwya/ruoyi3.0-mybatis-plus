package com.ruoyi.web.controller.business;


import com.ruoyi.business.entity.Bank;
import com.ruoyi.business.service.IBankService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
public class BankController extends BaseController {

    @Resource
    private IBankService service;

    @GetMapping("/list")
    public TableDataInfo getList(){
        List<Bank> list = service.list();
        return getDataTable(list);
    }


}
