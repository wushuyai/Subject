package com.jingdianjichi.subject.domain.handler.subject;

import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
import com.jingdianjichi.subject.domain.convert.RadioSubjectConverter;
import com.jingdianjichi.subject.domain.entity.SubjectAnswerBO;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.domain.entity.SubjectOptionBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectJudge;
import com.jingdianjichi.subject.infra.basic.entity.SubjectRadio;
import com.jingdianjichi.subject.infra.basic.service.SubjectJudgeService;
import com.jingdianjichi.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
//判断处理
public class JudgeTypeHandler implements SubjectTypeHandler{
    @Resource
    private SubjectRadioService subjectRadioService;
    @Resource
    private SubjectJudgeService subjectJudgeService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }
//单选题的插入
@Override
public void add(SubjectInfoBO subjectInfoBO) {
    //判断题目的插入
    SubjectJudge subjectJudge = new SubjectJudge();
    SubjectAnswerBO subjectAnswerBO = subjectInfoBO.getOptionList().get(0);
    subjectJudge.setSubjectId(subjectInfoBO.getId());
    subjectJudge.setIsCorrect(subjectAnswerBO.getIsCorrect());
    subjectJudge.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
    subjectJudgeService.insert(subjectJudge);
}

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectRadio subjectRadio = new SubjectRadio();
        subjectRadio.setSubjectId(Long.valueOf(subjectId));
        List<SubjectRadio> result = subjectRadioService.queryByCondition(subjectRadio);
        List<SubjectAnswerBO> subjectAnswerBOList = RadioSubjectConverter.INSTANCE.convertEntityToBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }
}
