package com.jingdianjichi.subject.application.controller;


import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.subject.application.convert.SubjectAnswerDTOConverter;
import com.jingdianjichi.subject.application.convert.SubjectCategoryDTOConverter;
import com.jingdianjichi.subject.application.convert.SubjectInfoDTOConverter;
import com.jingdianjichi.subject.application.dto.SubjectAnswerDTO;
import com.jingdianjichi.subject.application.dto.SubjectCategoryDTO;
import com.jingdianjichi.subject.application.dto.SubjectInfoDTO;
import com.jingdianjichi.subject.common.entity.PageResult;
import com.jingdianjichi.subject.common.entity.Result;
import com.jingdianjichi.subject.domain.entity.SubjectAnswerBO;
import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.domain.service.SubjectCategoryDomainService;
import com.jingdianjichi.subject.domain.service.SubjectInfoDomainService;
//import com.jingdianjichi.subject.infra.basic.entity.SubjectCategory;
//import com.jingdianjichi.subject.infra.basic.service.SubjectCategoryService;
//import com.jingdianjichi.subject.infra.basic.service.SubjectInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 接收请求：
 * Web 项目：处理 HTTP 请求
 * REST 项目：返回 JSON / XML
 * 调用 Service 层处理业务
 * 返回响应给前端或客户端
 * **/
@RestController
@RequestMapping("/subject")//公共前缀
@Slf4j
public class SubjectController {

    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;

    /**
     * 接收 POST 请求，插入一条新的 SubjectCategoryDTO
     * *@param SubjectCategoryDTO 前端传来的 JSON，会自动映射为 SubjectCategory 对象
     * @return 插入成功提示
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.add.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
//            检查内容是否为空
//            题目名称不能为空
            Preconditions.checkArgument(StringUtils.isNotBlank(subjectInfoDTO.getSubjectName()), "分类名称不能为空");
//           难度不能为空
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(), "难度不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(), "分数不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(), "题目类型不能为空");
//            分类id不能为空
//            参数合法性校验/集合等参数校验
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds()), "分类id不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDtoToInfoBO(subjectInfoDTO);
//            主体内嵌套的内容转换
            List<SubjectAnswerBO> subjectAnswerBOS=SubjectAnswerDTOConverter.INSTANCE.convertDTOToAnswerBOList(subjectInfoDTO.getOptionList());
//            将转换后的答案选项添加到主体内
            subjectInfoBO.setOptionList(subjectAnswerBOS);
            subjectInfoDomainService.add(subjectInfoBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectInfoController.add.error:{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        }

    }
    @PostMapping("/getSubjectPage")
    public Result<PageResult<SubjectInfoDTO>> getSubjectPage(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.add.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }

//           分类id不能为空
            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(), "分类id不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(), "标签id不能为空");
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDtoToInfoBO(subjectInfoDTO);
//
            PageResult<SubjectInfoBO> pageResult = subjectInfoDomainService.getSubjectPage(subjectInfoBO);
            return Result.ok(pageResult);
        } catch (Exception e) {
            log.error("SubjectInfoController.add.error:{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        }

    }
    /**
     * 查询题目信息
     */
    @PostMapping("/querySubjectInfo")
    public Result<SubjectInfoDTO> querySubjectInfo(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.querySubjectInfo.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkNotNull(subjectInfoDTO.getId(), "题目id不能为空");
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDtoToInfoBO(subjectInfoDTO);
            SubjectInfoBO boResult = subjectInfoDomainService.querySubjectInfo(subjectInfoBO);
            SubjectInfoDTO dto = SubjectInfoDTOConverter.INSTANCE.convertBOToDTO(boResult);
            return Result.ok(dto);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail("查询题目详情失败");
        }
    }

}
