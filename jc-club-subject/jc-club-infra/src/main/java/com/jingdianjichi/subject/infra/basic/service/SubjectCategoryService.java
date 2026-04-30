package com.jingdianjichi.subject.infra.basic.service;

import com.jingdianjichi.subject.infra.basic.entity.SubjectCategory;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * (SubjectCategory)表服务接口
 *
 * @author makejava
 * @since 2026-04-08 20:54:14
 */

public interface SubjectCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectCategory queryById(Long id);

    /**
     * 分页查询
     *
     * @param subjectCategory 筛选条件

     */

    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    SubjectCategory insert(SubjectCategory subjectCategory);

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    SubjectCategory update(SubjectCategory subjectCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);
    /**
     * 查询岗位大类
     */
    List<SubjectCategory> queryPrimaryCategory();

    List<SubjectCategory> queryCategoryByPrimary(SubjectCategory subjectCategory);

}
