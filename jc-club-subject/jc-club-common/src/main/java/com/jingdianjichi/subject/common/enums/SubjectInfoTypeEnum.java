package com.jingdianjichi.subject.common.enums;

import lombok.Getter;

/**
 * 题目类型枚举
 *
 * @author: ChickenWing
 * @date: 2023/10/3
 */
@Getter
public enum SubjectInfoTypeEnum {

    RADIO(1, "单选题"),
    MULTIPLE(2, "多选题"),
    JUDGE(3, "判断题"),
    BRIEF(4, "简答题");
    public int code;

    public String desc;

    SubjectInfoTypeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static SubjectInfoTypeEnum getByCode(int codeVal){
        for(SubjectInfoTypeEnum resultCodeEnum : SubjectInfoTypeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}

