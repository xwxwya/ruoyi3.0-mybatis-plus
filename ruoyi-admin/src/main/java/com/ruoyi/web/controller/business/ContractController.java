package com.ruoyi.web.controller.business;

import com.ruoyi.business.entity.Contract;
import com.ruoyi.business.service.ContractService;
import com.ruoyi.common.core.domain.AjaxResult;
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
@RequestMapping("/contract")
public class ContractController {

    @Resource
    private ContractService service;

//    @GetMapping("/get")
////    @SerializationFilters(filters = {
////            @SerializationFilter(target = BaseEntity.class,fields = {},exclusive = false),
////            @SerializationFilter(target = SysUser.class,fields = {"nickName","userName"},exclusive = false)
////    })
//    public AjaxResult get(){
//        List<Contract> all = service.getAll();
//        return AjaxResult.success(all);
//    }

    @GetMapping("/example")
    public AjaxResult example(){
        List<Contract> res = service.example();
        return AjaxResult.success(res);
    }
}
