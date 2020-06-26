package com.miracle.entity.admin.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Miracle
 * @date 10:17 2019/6/30
 */
@Data
@Accessors(chain = true)
@TableName("blog_dict_item")
public class DictDTO implements Serializable {

    private static final long serialVersionUID = -2613507073210794690L;

    @TableId(value = "dict_id", type = IdType.AUTO)
    private Long dictId;

    private Integer itemValue;

    private String itemName;

    private Integer itemOrder;

}
