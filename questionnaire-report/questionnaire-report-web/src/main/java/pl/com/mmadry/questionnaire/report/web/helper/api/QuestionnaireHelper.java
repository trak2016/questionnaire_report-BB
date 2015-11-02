package pl.com.mmadry.questionnaire.report.web.helper.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.com.mmadry.questionnaire.report.core.model.Questionnaire;
import pl.com.mmadry.questionnaire.report.core.service.QuestionnaireService;
import pl.com.mmadry.questionnaire.report.web.assembler.QuestionnaireAssembler;
import pl.com.mmadry.questionnaire.report.web.assembler.parameters.QuestionnaireAssemblerParameters;
import pl.com.mmadry.questionnaire.report.web.dto.QuestionnaireDTO;
import pl.com.mmadry.questionnaire.report.web.helper.BaseHelper;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Component
public class QuestionnaireHelper extends BaseHelper{
    
    @Autowired
    private QuestionnaireService questionnaireService;
    @Autowired
    private QuestionnaireAssembler questionnaireAssembler;
    
    public List<QuestionnaireDTO> getAll(){
        List<QuestionnaireDTO> questionnaireDTOs = new ArrayList<>();
        List<Questionnaire> questionnaires = questionnaireService.getElements();
        
        for(Questionnaire questionnaire : questionnaires){
            QuestionnaireAssemblerParameters parameters = new QuestionnaireAssemblerParameters.Builder()
                    .dbo(questionnaire)
                    .build();
            questionnaireDTOs.add(questionnaireAssembler.assemblyToDto(parameters));
        }
        return questionnaireDTOs;
    }
    
    
}
