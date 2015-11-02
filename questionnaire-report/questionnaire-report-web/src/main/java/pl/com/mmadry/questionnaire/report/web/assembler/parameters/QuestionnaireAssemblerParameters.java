package pl.com.mmadry.questionnaire.report.web.assembler.parameters;

import pl.com.mmadry.questionnaire.report.core.model.Questionnaire;
import pl.com.mmadry.questionnaire.report.web.dto.QuestionnaireDTO;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class QuestionnaireAssemblerParameters {
    
    private final Questionnaire dbo;
    private final QuestionnaireDTO dto;

    private QuestionnaireAssemblerParameters(Questionnaire dbo, QuestionnaireDTO dto) {
        this.dbo = dbo;
        this.dto = dto;
    }

    public Questionnaire getDbo() {
        return dbo;
    }

    public QuestionnaireDTO getDto() {
        return dto;
    }

    public static class Builder {

        private Questionnaire dbo;
        private QuestionnaireDTO dto;

        public Builder dbo(Questionnaire dbo) {
            this.dbo = dbo;
            return this;
        }

        public Builder dto(QuestionnaireDTO dto) {
            this.dto = dto;
            return this;
        }

        public QuestionnaireAssemblerParameters build() {
            return new QuestionnaireAssemblerParameters(dbo, dto);
        }
    }
}
