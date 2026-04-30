package com.jingdianjichi.subject.domain.service;

import com.jingdianjichi.subject.common.entity.PageResult;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;

import java.util.List;

public interface SubjectInfoDomainService {
    void add(SubjectInfoBO subjectInfoBO);
    /**
     * 分页查询题目
     */
    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);
    /**
     * 查询题目
     */
    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);
}
