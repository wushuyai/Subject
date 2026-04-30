package com.jingdianjichi.subject.domain.handler.subject;

import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.domain.entity.SubjectOptionBO;

public interface SubjectTypeHandler {
//    枚举身份的识别
    SubjectInfoTypeEnum getHandlerType();

    void add(SubjectInfoBO subjectInfoBO);

    SubjectOptionBO query(int subjectId);

}
