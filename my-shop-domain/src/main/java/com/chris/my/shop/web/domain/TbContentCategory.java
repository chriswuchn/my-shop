package com.chris.my.shop.web.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import dto.persistence.BaseEntity;
import lombok.Data;

/**
 * 分类管理
 */
@Data
public class TbContentCategory extends BaseEntity {
    private Long parentId;
    private String name;
    private Integer status;
    private Integer sortOrder;
    private Boolean isParent;
}

