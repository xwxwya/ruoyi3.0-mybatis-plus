package com.ruoyi.common.mybatisPlus;

import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author xw
 * @version 1.0
 * @date 2021/11/22 16:36
 */
public class MyBaseServiceImpl<M extends MyBaseMapper<T>, T> extends ServiceImpl<M, T> implements MyBaseService<T> {

    @Override
    public int saveOrUpdateAllColumn(T entity) {
        M mapper = this.getBaseMapper();
        Class<?> cls = entity.getClass();
        TableInfo tableInfo = TableInfoHelper.getTableInfo(cls);
        Assert.notNull(tableInfo, "error: can not execute. because can not find cache of TableInfo for entity!", new Object[0]);
        String keyProperty = tableInfo.getKeyProperty();
        Assert.notEmpty(keyProperty, "error: can not execute. because can not find column for id from entity!", new Object[0]);
        Object idVal = ReflectionKit.getFieldValue(entity, tableInfo.getKeyProperty());
        return !StringUtils.checkValNull(idVal) && !Objects.isNull(this.getById((Serializable) idVal)) ? mapper.alwaysUpdateSomeColumnById(entity) : mapper.insert(entity);
    }
}
