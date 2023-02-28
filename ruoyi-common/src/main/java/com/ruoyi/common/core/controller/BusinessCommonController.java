package com.ruoyi.common.core.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.mybatisPlus.MyBaseService;
import com.ruoyi.common.mybatisPlus.QuerySelective;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author xw
 * @date 2023/2/28 9:57
 */
public abstract class BusinessCommonController<S extends MyBaseService<E>,E> extends BaseController {

    public abstract S getService();

    @GetMapping("/list")
    public TableDataInfo getList(E entity){
        startPage();
        QueryWrapper<E> queryWrapper = QuerySelective.notNullField(entity);
        List<E> list = getService().list(queryWrapper);
        return getDataTable(list);
    }

    @PostMapping("")
    public AjaxResult add(@RequestBody E entity){
        getService().save(entity);
        return AjaxResult.success();
    }

    @PutMapping("")
    public AjaxResult update(@RequestBody E entity){
        getService().saveOrUpdateAllColumn(entity);
        return AjaxResult.success();
    }

    @DeleteMapping("/delete")
    public AjaxResult delete(Integer []ids){
        if (ids==null||ids.length==0){
            return AjaxResult.success();
        }
        List<Integer> list = Arrays.asList(ids);
        UpdateWrapper<E> up = new UpdateWrapper<>();
        up.in("id",list);
        getService().remove(up);
        return AjaxResult.success();
    }

    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id){
        E res = getService().getById(id);
        return AjaxResult.success(res);
    }

}
