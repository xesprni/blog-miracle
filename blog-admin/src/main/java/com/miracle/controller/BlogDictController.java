package com.miracle.controller;

import com.miracle.api.admin.IDictService;
import com.miracle.entity.admin.po.DictPO;
import com.miracle.model.ModelResult;
import com.miracle.model.ModelResultClient;
import com.miracle.model.PageResultConvert;
import com.miracle.repository.admin.mapper.BlogDictMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Miracle
 * @date 15:07 2020/6/26
 */
@RestController
public class BlogDictController implements IDictService {

    private final BlogDictMapper blogDictMapper;

    public BlogDictController(BlogDictMapper blogDictMapper) {
        this.blogDictMapper = blogDictMapper;
    }

    @Override

    @Cacheable(value = "dictCache", key = "#dictName")
    public ModelResult<List<DictPO>> getDictByItem(@RequestParam("dictName") String dictName) {
        return new ModelResultClient<List<DictPO>>().success(PageResultConvert.convert(blogDictMapper.queryDictByDictName(dictName),DictPO.class));
    }

}
