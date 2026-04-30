package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.subject.application.dto.SubjectInfoDTO;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 题目信息dto转换器
 *
 * @author: ChickenWing
 * @date: 2023/10/8
 */
@Mapper
public interface SubjectInfoDTOConverter {

    SubjectInfoDTOConverter INSTANCE = Mappers.getMapper(SubjectInfoDTOConverter.class);

    SubjectInfoBO convertDtoToInfoBO(SubjectInfoDTO subjectInfoDTO);
//    SubjectInfoDTO convertInfoToDTO(SubjectInfoBO subjectInfoBO);
    SubjectInfoDTO  convertBOToDTO(SubjectInfoBO subjectInfoBO);

//    SubjectInfoDTO convertBOToDTO(SubjectInfoBO subjectInfoBO);

//    List<SubjectInfoDTO> convertBOToDTOList(List<SubjectInfoBO> subjectInfoBO);

}
