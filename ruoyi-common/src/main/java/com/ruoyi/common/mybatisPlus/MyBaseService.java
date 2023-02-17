package com.ruoyi.common.mybatisPlus;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author xw
 * @version 1.0
 * @date 2021/11/22 16:36
 */
public interface MyBaseService<T> extends IService<T> {

    int saveOrUpdateAllColumn(T entity);
}
