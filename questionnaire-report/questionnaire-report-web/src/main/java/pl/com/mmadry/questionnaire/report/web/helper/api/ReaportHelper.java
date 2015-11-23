package pl.com.mmadry.questionnaire.report.web.helper.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.com.mmadry.questionnaire.report.core.model.Answer;
import pl.com.mmadry.questionnaire.report.core.model.Question;
import pl.com.mmadry.questionnaire.report.core.model.Questionnaire;
import pl.com.mmadry.questionnaire.report.core.service.QuestionnaireService;
import pl.com.mmadry.questionnaire.report.web.dto.AnswerReaportDTO;
import pl.com.mmadry.questionnaire.report.web.dto.QuestionReaportDTO;
import pl.com.mmadry.questionnaire.report.web.dto.ReaportDTO;
import pl.com.mmadry.questionnaire.report.web.helper.BaseHelper;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Component
public class ReaportHelper extends BaseHelper{
    
    @Autowired
    private QuestionnaireService questionnaireService;
    
    public ReaportDTO generalReaport(Long id){
        ReaportDTO dto = new ReaportDTO();
        
        Questionnaire q = questionnaireService.getElement(id);
        
        dto.setQuestionnaireDescription(q.getDescription());
        dto.setQuestionnaireTarger(q.getTarger());
        dto.setQuestionnaireTitle(q.getTitle());
        
        for(Question question : q.getQuestions()){
            QuestionReaportDTO qDto = new QuestionReaportDTO();
            qDto.setText(question.getText());
            qDto.setType(question.getType());
            
            for(Answer answer : question.getAnswers()){
                AnswerReaportDTO aDTO = new AnswerReaportDTO();
                aDTO.setText(answer.getText());
                aDTO.setCount(answer.getUserDatas().size());
                qDto.getAnswers().add(aDTO);
            }
            dto.getQuestions().add(qDto);
        }
        
        return dto;
    }
    
}
