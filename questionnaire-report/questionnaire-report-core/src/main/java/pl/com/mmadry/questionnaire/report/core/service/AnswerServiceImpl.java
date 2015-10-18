package pl.com.mmadry.questionnaire.report.core.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.mmadry.questionnaire.report.core.model.Answer;
import pl.com.mmadry.questionnaire.report.core.repository.AnswerRepository;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    @Transactional(readOnly = true)
    public Answer getElement(Long id) {
        return answerRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Answer> getElements() {
        return answerRepository.findAll();
    }

    @Override
    public void add(Answer element) {
        answerRepository.save(element);
    }

    @Override
    public void update(Answer element) {
        answerRepository.save(element);
    }

    @Override
    public void delete(Answer element) {
        answerRepository.delete(element);
    }

    @Override
    public void deleteById(Long id) {
        answerRepository.delete(id);
    }

    @Override
    public Answer save(Answer element) {
        return answerRepository.save(element);
    }

}
