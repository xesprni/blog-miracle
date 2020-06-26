package com.miracle.api.admin;

import com.miracle.entity.admin.po.DictPO;
import com.miracle.model.ModelResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Miracle
 * @date 8:49 2020/6/25
 */
@FeignClient(name = "blog-admin")
@RequestMapping("/dict")
public interface IDictService {

    /**
     * getDictByName
     *
     * @param dictName name
     * @return dict
     */
    @PostMapping("/getDictByItem")
    ModelResult<List<DictPO>> getDictByItem(@RequestParam("dictName") String dictName);

}
