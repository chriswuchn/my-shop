package com.chris.my.shop.web.domain;


import dto.persistence.BaseEntity;
import lombok.Data;

/**
 * 内容管理实体类
 *
 */
@Data
public class TbContent extends BaseEntity {
    private Long categoryId;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    private String content;
}
