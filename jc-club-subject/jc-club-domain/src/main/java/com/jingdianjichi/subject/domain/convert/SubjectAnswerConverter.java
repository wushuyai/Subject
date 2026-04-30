package com.jingdianjichi.subject.domain.convert;

import com.jingdianjichi.subject.domain.entity.SubjectAnswerBO;
import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectAnswer;
import com.jingdianjichi.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectAnswerConverter {
    SubjectAnswerConverter INSTANCE = Mappers.getMapper(SubjectAnswerConverter.class);

    List<SubjectAnswer> convertBoToAnswer(List<SubjectAnswerBO> subjectAnswerBOList);
}
