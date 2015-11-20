package pl.com.mmadry.questionnaire.report.web.helper.api;

import com.google.common.collect.ImmutableMap;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import pl.com.mmadry.questionnaire.report.core.model.Answer;
import pl.com.mmadry.questionnaire.report.core.model.Question;
import pl.com.mmadry.questionnaire.report.core.model.Questionnaire;
import pl.com.mmadry.questionnaire.report.core.model.Task;
import pl.com.mmadry.questionnaire.report.web.helper.BaseHelper;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Component
@Transactional
public class IndexHelper extends BaseHelper {

    public class IndexInfo {

        public Integer index;
        public boolean allTestOK;

    }

    private Map<String, Integer> weight = ImmutableMap.<String, Integer>builder()
            .put("W1", 10) //title
            .put("W2", 10) //targer
            .put("W3", 10) //description
            .put("W4", 20) // one question
            .put("W5", 20) // all questions correct
            .put("W6", 10) // date end
            .put("W7", 20) // users

            .build();

    private Map<String, Integer> resultTest = new HashMap<>();

    public IndexInfo calculateIndex(Questionnaire questionnaire) {
        startTest(questionnaire);
        IndexInfo returnValue = new IndexInfo();

        int suma = 0;
        for (int i = 1; i <= resultTest.size(); i++) {
            suma += resultTest.get("A" + i) * weight.get("W" + i);
        }
        returnValue.index = suma;
        returnValue.allTestOK = false;
        if (resultTest.get("A1") == 1 && resultTest.get("A4") == 1 
                && resultTest.get("A5") == 1 && resultTest.get("A6") == 1 
                && resultTest.get("A7") == 1) {
            returnValue.index = suma;
            returnValue.allTestOK = true;
            return returnValue;

        }

        if (resultTest.get("A1") == 0 || resultTest.get("A4") == 0 
                || resultTest.get("A5") == 0 || resultTest.get("A6") == 0 
                || resultTest.get("A7") == 0) {
            returnValue.allTestOK = false;
            if (suma > 51) {
                returnValue.index = 40;
                return returnValue;
            } else {
                returnValue.index = suma;
                return returnValue;
            }
        }

        return returnValue;
    }

    private void startTest(Questionnaire questionnaire) {
        List<Question> question = questionnaire.getQuestions();

        A1(questionnaire.getTitle());
        A2(questionnaire.getTarger());
        A3(questionnaire.getDescription());
        A4(question);
        A5(question);
        A6(questionnaire.getTimeEnd());
        A7(questionnaire.getTasks());

    }

    /**
     * Weryfikacja zaklada, że w tresci będzie minimum 25 znaków
     * nieuwzględniajac spacji i kropek
     *
     * @param title
     */
    private void A1(String title) {

        if (title == null) {
            resultTest.put("A1", 0);
            return;
        }
        String titleWithNoWhitespces = title.replace(" ", "");
        titleWithNoWhitespces = titleWithNoWhitespces.replace(".", "");
        if (titleWithNoWhitespces.length() >= 10) {
            resultTest.put("A1", 1);
        } else {
            resultTest.put("A1", 0);
        }

    }

    private void A2(String targer) {
        if (targer == null) {
            resultTest.put("A2", 0);
            return;
        }
        String targerWithNoWhitespces = targer.replace(" ", "");
        targerWithNoWhitespces = targerWithNoWhitespces.replace(".", "");
        if (targerWithNoWhitespces.length() >= 10) {
            resultTest.put("A2", 1);
        } else {
            resultTest.put("A2", 0);
        }

    }

    private void A3(String description) {

        if (description == null) {
            resultTest.put("A3", 0);
            return;
        }
        String descriptionWithNoWhitespces = description.replace(" ", "");
        descriptionWithNoWhitespces = descriptionWithNoWhitespces.replace(".", "");
        if (descriptionWithNoWhitespces.length() >= 10) {
            resultTest.put("A3", 1);
        } else {
            resultTest.put("A3", 0);
        }

    }

    private void A4(List<Question> questions) {
        if (questions == null || questions.isEmpty()) {
            resultTest.put("A4", 0);
        } else {
            resultTest.put("A4", 1);
        }
    }

    private void A5(List<Question> questions) {
        
        if (questions == null || questions.isEmpty()) {
            resultTest.put("A5", 0);
            return;
        }

        Boolean test = true;

        for (Question question : questions) {
            String textWithNoWhitespces = question.getText().replace(" ", "");
            textWithNoWhitespces = textWithNoWhitespces.replace(".", "");
            if (textWithNoWhitespces.length() < 10) {
                test = false;
                break;
            }

            if (!question.getType().equals("text") && (question.getAnswers() == null || question.getAnswers().isEmpty())) {
                test = false;
                break;
            }

            for (Answer answer : question.getAnswers()) {
                textWithNoWhitespces = answer.getText().replace(" ", "");
                textWithNoWhitespces = textWithNoWhitespces.replace(".", "");
                if (textWithNoWhitespces.length() < 10) {
                    test = false;
                    break;
                }
            }
        }

        if (test) {
            resultTest.put("A5", 1);
        } else {
            resultTest.put("A5", 0);
        }
    }
    
     private void A6(Date dateEnd) {
        if (dateEnd == null || dateEnd.before(new Date())) {
            resultTest.put("A6", 0);
        } else {
            resultTest.put("A6", 1);
        }
    }
     
      private void A7(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            resultTest.put("A7", 0);
        } else {
            resultTest.put("A7", 1);
        }
    }

}
