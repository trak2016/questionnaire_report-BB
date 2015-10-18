package pl.com.mmadry.questionnaire.report.core.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.mmadry.questionnaire.report.core.model.Question;
import pl.com.mmadry.questionnaire.report.core.repository.QuestionRepository;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Question getElement(Long id) {
        return questionRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Question> getElements() {
        return questionRepository.findAll();
    }

    @Override
    public void add(Question element) {
        questionRepository.save(element);
    }

    @Override
    public void update(Question element) {
        questionRepository.save(element);
    }

    @Override
    public void delete(Question element) {
        questionRepository.delete(element);
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.delete(id);
    }

    @Override
    public Question save(Question element) {
        return questionRepository.save(element);
    }
    
}
