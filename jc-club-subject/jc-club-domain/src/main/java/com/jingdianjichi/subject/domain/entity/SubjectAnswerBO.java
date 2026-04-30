package com.jingdianjichi.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class SubjectAnswerBO implements Serializable {
    private Integer optionType;

    private String optionContent;

    private Integer isCorrect;
}
