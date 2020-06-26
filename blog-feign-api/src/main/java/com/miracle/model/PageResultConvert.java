package com.miracle.model;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;

/**
 * @author Miracle
 * @date 12:26 2020/6/25
 */
public class PageResultConvert {

    public static <T, K> PageResult<T> convert(Page<K> source,Class<T> tClass) {
        PageResult<T> result = new PageResult<>();
        if (source != null && source.getTotal() > 0) {
            List<T> newList = Lists.newArrayList();
            source.getRecords().forEach(k -> newList.add(BeanUtil.copyProperties(k,tClass)));
            result.setPageData(newList);
            result.setPageNum(source.getCurrent());
            result.setTotal(source.getTotal());
            result.setPageSize(source.getSize());
            return result;
        }
        return null;
    }

    public static <T, K> List<K> convert(List<T> source,Class<K> tClass) {
        List<K> result = Lists.newArrayList();
        if (!source.isEmpty()) {
            source.stream().filter(Objects::nonNull).forEach(t -> result.add(BeanUtil.copyProperties(t,tClass)));
            return result;
        }
        return null;
    }

}
