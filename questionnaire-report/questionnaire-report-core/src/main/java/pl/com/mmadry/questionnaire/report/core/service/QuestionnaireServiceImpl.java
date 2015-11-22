package pl.com.mmadry.questionnaire.report.core.service;

import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.mmadry.questionnaire.report.core.enums.QuestionnaireType;
import pl.com.mmadry.questionnaire.report.core.model.Questionnaire;
import pl.com.mmadry.questionnaire.report.core.repository.QuestionnaireRepository;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Service
@Transactional
public class QuestionnaireServiceImpl implements QuestionnaireService{

    @Autowired
    private QuestionnaireRepository questionnaireRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Questionnaire getElement(Long id) {
        return questionnaireRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Questionnaire> getElements() {
        return questionnaireRepository.findAll();
    }

    @Override
    public void add(Questionnaire element) {
        questionnaireRepository.save(element);
    }

    @Override
    public void update(Questionnaire element) {
        questionnaireRepository.save(element);
    }

    @Override
    public void delete(Questionnaire element) {
        questionnaireRepository.delete(element);
    }

    @Override
    public void deleteById(Long id) {
        questionnaireRepository.delete(id);
    }

    @Override
    public Questionnaire save(Questionnaire element) {
        return questionnaireRepository.save(element);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Questionnaire> getByStatus(QuestionnaireType ststus) {
       return questionnaireRepository.findByStatusAndRemovedFalse(ststus);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Questionnaire> getByStatusAndDateEndBefore(QuestionnaireType ststus, Date endTime) {
        return questionnaireRepository.findByStatusAndTimeEndBefore(ststus, endTime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Questionnaire> getByStatusAndDateEndAfter(QuestionnaireType ststus, Date endTime) {
        return questionnaireRepository.findByStatusAndTimeEndAfter(ststus, endTime);
    }
    
}
