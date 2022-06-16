package com.ruoyi.common.mybatisPlus;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xw
 * @version 1.0
 * @date 2021/11/12 14:04
 */

public class QuerySelective<T> extends QueryWrapper<T> {
    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * @param T
     * @param likeColumn 需要设置成like的字段
     * @param <T>
     * @return
     */
    public static <T> QueryWrapper notNullField(T T, String... likeColumn) {
        int length = likeColumn.length;
        List<String> list = null;
        if (length > 0) {
            list = Arrays.asList(likeColumn);
        }
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        for (Field field : T.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                //序列化 字段不需要查询
                if ("serialVersionUID".equals(field.getName())) {
                    continue;
                }
                //属性为空，不用查询
                Object o = field.get(T);
                if (o == null) {
                    continue;
                }else if (field.getType()== String.class){
                    if (String.valueOf(o).trim().equals("")){
                        continue;
                    }
                }
                //主键 注解TableId
                TableId tableId = field.getAnnotation(TableId.class);
                if (tableId != null) {
                    //主键
                    wrapper.eq(tableId.value(), field.get(T));
                    continue;
                }
                //数据库中字段名和实体类属性不一致 注解TableField
                TableField tableField = field.getAnnotation(TableField.class);
                if (tableField != null) {
                    if (tableField.exist()) {
                        String value = tableField.value();
                        if (length > 0 && list.contains(value)) {
                            wrapper.like(value, field.get(T));
                        } else {
                            wrapper.eq(value, field.get(T));
                        }
                    }// @TableField(exist = false) 不是表中内容 不形成查询条件
                    continue;
                }
                String name = field.getName();
                //数据库中字段名和实体类属性一致
                if (length > 0 && list.contains(name)) {
                    wrapper.like(humpToLine(name), field.get(T));
                } else {
                    wrapper.eq(humpToLine(name), field.get(T));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return wrapper;
    }

    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
