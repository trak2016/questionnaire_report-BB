package pl.com.mmadry.questionnaire.report.web.assembler;

import com.google.common.base.Preconditions;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import pl.com.mmadry.questionnaire.report.core.model.Questionnaire;
import pl.com.mmadry.questionnaire.report.web.assembler.commons.Assembler;
import pl.com.mmadry.questionnaire.report.web.assembler.parameters.QuestionnaireAssemblerParameters;
import pl.com.mmadry.questionnaire.report.web.dto.QuestionnaireDTO;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Component
public class QuestionnaireAssembler implements Assembler<Questionnaire, QuestionnaireDTO, QuestionnaireAssemblerParameters> {

    private static final String[] EXCLUDED_FIELDS = new String[]{"questions", "userDatas", "tasks", "term"};

    @Override
    public Questionnaire assemblyToDbo(QuestionnaireAssemblerParameters parameters) {
        Preconditions.checkArgument(parameters.getDto() != null, "Dto must be not null");
        Questionnaire dbo = parameters.getDbo() == null ? new Questionnaire() : parameters.getDbo();
        BeanUtils.copyProperties(parameters.getDto(), dbo, EXCLUDED_FIELDS);

        return dbo;
    }

    @Override
    public QuestionnaireDTO assemblyToDto(QuestionnaireAssemblerParameters parameters) {
        Preconditions.checkArgument(parameters.getDbo() != null, "Dbo must be not null");
        QuestionnaireDTO dto = parameters.getDto() == null ? new QuestionnaireDTO() : parameters.getDto();
        BeanUtils.copyProperties(parameters.getDbo(), dto, EXCLUDED_FIELDS);

        return dto;
    }

}
