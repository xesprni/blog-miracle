package com.miracle.repository.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miracle.entity.admin.dto.DictDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Miracle
 */
@Repository
public interface BlogDictMapper extends BaseMapper<DictDTO> {

    /**
     * queryDictByDictName
     *
     * @param name name
     * @return dict
     */
    List<DictDTO> queryDictByDictName(@Param("name") String name);
}