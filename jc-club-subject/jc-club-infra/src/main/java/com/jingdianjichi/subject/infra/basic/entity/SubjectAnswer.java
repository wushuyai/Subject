package com.jingdianjichi.subject.infra.basic.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class SubjectAnswer implements Serializable {
    private Integer optionType;

    private String optionContent;

    private Integer isCorrect;
}
