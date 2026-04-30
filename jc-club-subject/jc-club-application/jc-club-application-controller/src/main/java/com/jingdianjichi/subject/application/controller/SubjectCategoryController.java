package com.jingdianjichi.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.subject.application.convert.SubjectCategoryDTOConverter;
import com.jingdianjichi.subject.application.dto.SubjectCategoryDTO;
import com.jingdianjichi.subject.common.entity.Result;
import com.jingdianjichi.subject.domain.convert.SubjectCategoryConverter;
import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import com.jingdianjichi.subject.domain.service.SubjectCategoryDomainService;
import com.jingdianjichi.subject.infra.basic.entity.SubjectCategory;
import com.jingdianjichi.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping ("/subject/category")//公共前缀
@Slf4j
public class SubjectCategoryController {
    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    /**
     * 接收 POST 请求，插入一条新的 SubjectCategoryDTO
     * *@param SubjectCategoryDTO 前端传来的 JSON，会自动映射为 SubjectCategory 对象
     * @return 插入成功提示
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.add.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
//            检查内容是否为空
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(), "分类类型不能为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(subjectCategoryDTO.getCategoryName()), "分类名称不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "分类父级id不能为空");
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDtoToCategoryBO(subjectCategoryDTO);
            subjectCategoryDomainService.add(subjectCategoryBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        }

        }
//        查询一级分类
    @PostMapping("/queryPrimaryCategory")
    public Result<List<SubjectCategoryDTO>> queryPrimaryCategory() {
    try {
        List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.
                queryPrimaryCategory();
        List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.
                INSTANCE.convertBoToCategoryDTOList(subjectCategoryBOList);
        return Result.ok(subjectCategoryDTOList);
    } catch (Exception e) {
        log.error("SubjectCategoryController.queryPrimaryCategory.error:{}", e.getMessage(), e);
        return Result.fail("查询失败");
    }

}
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {

        // 1️⃣ 参数校验
        if (subjectCategoryDTO == null || subjectCategoryDTO.getId() == null) {
            return Result.fail("id不能为空");
        }

        // 2️⃣ DTO → BO 转换
        SubjectCategoryBO subjectCategoryBO =
                SubjectCategoryDTOConverter.INSTANCE.convertDtoToCategoryBO(subjectCategoryDTO);

        // 3️⃣ 调用领域服务
        subjectCategoryDomainService.update(subjectCategoryBO);

        // 4️⃣ 返回结果
        return Result.ok(true);
    }
    @PostMapping("/queryCategoryByPrimary")
    public Result<List<SubjectCategoryDTO>> queryCategoryByPrimary(SubjectCategoryDTO subjectCategoryDTO) {
        try {
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDtoToCategoryBO(subjectCategoryDTO);
            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.
                    queryCategoryByPrimary(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.
                    INSTANCE.convertBoToCategoryDTOList(subjectCategoryBOList);
            return Result.ok(subjectCategoryDTOList);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryPrimaryCategory.error:{}", e.getMessage(), e);
            return Result.fail("查询失败");
        }
    }
@PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.delete.dto:{}",
                        JSON.toJSONString(subjectCategoryDTO));
            }

            // 1️⃣ 参数校验
            Preconditions.checkNotNull(subjectCategoryDTO.getId(), "id不能为空");

            // 2️⃣ DTO → BO
            SubjectCategoryBO subjectCategoryBO =
                    SubjectCategoryDTOConverter.INSTANCE.convertDtoToCategoryBO(subjectCategoryDTO);

            // 3️⃣ 调用业务层删除
            subjectCategoryDomainService.delete(subjectCategoryBO);

            return Result.ok(true);

        } catch (Exception e) {
            log.error("SubjectCategoryController.delete.error:{}", e.getMessage(), e);
            return Result.fail("删除失败");
        }
    }

}
