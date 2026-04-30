package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.subject.application.dto.SubjectAnswerDTO;
import com.jingdianjichi.subject.application.dto.SubjectCategoryDTO;
import com.jingdianjichi.subject.domain.entity.SubjectAnswerBO;
import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface SubjectAnswerDTOConverter {
    SubjectAnswerDTOConverter INSTANCE = Mappers.getMapper(SubjectAnswerDTOConverter.class);
//    SubjectAnswerBO convertDtoToAnswerBO(SubjectAnswerDTO subjectAnswerDTO);
    List<SubjectAnswerBO> convertDTOToAnswerBOList(List<SubjectAnswerDTO> subjectAnswerDTO);
//    SubjectAnswerDTO convertBoToAnswerDTO(SubjectAnswerBO subjectAnswerBO);
}
