package com.jingdianjichi.subject.application.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class SubjectAnswerDTO implements Serializable {
    private Integer optionType;

    private String optionContent;

    private Integer isCorrect;

}
