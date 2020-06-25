package com.miracle.model;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;

import java.util.List;

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
}
