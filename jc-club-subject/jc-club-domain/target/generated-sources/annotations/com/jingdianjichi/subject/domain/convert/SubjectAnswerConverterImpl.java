package com.jingdianjichi.subject.domain.convert;

import com.jingdianjichi.subject.domain.entity.SubjectAnswerBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectAnswer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-17T12:17:43+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class SubjectAnswerConverterImpl implements SubjectAnswerConverter {

    @Override
    public List<SubjectAnswer> convertBoToAnswer(List<SubjectAnswerBO> subjectAnswerBOList) {
        if ( subjectAnswerBOList == null ) {
            return null;
        }

        List<SubjectAnswer> list = new ArrayList<SubjectAnswer>( subjectAnswerBOList.size() );
        for ( SubjectAnswerBO subjectAnswerBO : subjectAnswerBOList ) {
            list.add( subjectAnswerBOToSubjectAnswer( subjectAnswerBO ) );
        }

        return list;
    }

    protected SubjectAnswer subjectAnswerBOToSubjectAnswer(SubjectAnswerBO subjectAnswerBO) {
        if ( subjectAnswerBO == null ) {
            return null;
        }

        SubjectAnswer subjectAnswer = new SubjectAnswer();

        subjectAnswer.setOptionType( subjectAnswerBO.getOptionType() );
        subjectAnswer.setOptionContent( subjectAnswerBO.getOptionContent() );
        subjectAnswer.setIsCorrect( subjectAnswerBO.getIsCorrect() );

        return subjectAnswer;
    }
}
