package com.jingdianjichi.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * (SubjectCategory)实体类
 *
 * @author makejava
 * @since 2026-04-08 20:54:07
 */
@Data
public class SubjectCategoryDTO implements Serializable {
    private static final long serialVersionUID = 115338796672504940L;
/**
     * 主键
     */
    private Long id;

    private String categoryName;
/**
     * 分类的类型
     */
    private Long categoryType;
/**
     * 图标链接
     */
    private String imageUrl;
/**
     * 父级id
     */
    private Long parentId;

}

