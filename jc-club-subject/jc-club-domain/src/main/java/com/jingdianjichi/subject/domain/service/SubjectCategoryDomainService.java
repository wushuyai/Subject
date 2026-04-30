package com.jingdianjichi.subject.domain.service;

import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;

import java.util.List;

public interface SubjectCategoryDomainService {
    void add(SubjectCategoryBO subjectCategoryBO);
    List<SubjectCategoryBO> queryPrimaryCategory();
    void update(SubjectCategoryBO subjectCategoryBO);
    List<SubjectCategoryBO> queryCategoryByPrimary(SubjectCategoryBO subjectCategoryBO);
    void delete(SubjectCategoryBO subjectCategoryBO);

//    void delete(SubjectCategoryBO subjectCategoryBO);
//    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);
}
