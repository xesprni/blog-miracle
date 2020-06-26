package com.miracle.entity.admin.po;

import lombok.Data;

/**
 * @author Miracle
 * @date 22:31 2020/6/26
 */
@Data
public class DictPO {

    private static final long serialVersionUID = -2613507073210794690L;

    private Long dictId;

    private Integer itemValue;

    private String itemName;

    private Integer itemOrder;
}
