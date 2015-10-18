package pl.com.mmadry.questionnaire.report.core.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.mmadry.questionnaire.report.core.model.Term;
import pl.com.mmadry.questionnaire.report.core.repository.TermRepository;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Service
@Transactional
public class TermServiceImpl implements TermService{

    @Autowired
    private TermRepository termRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Term getElement(Long id) {
        return termRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Term> getElements() {
        return termRepository.findAll();
    }

    @Override
    public void add(Term element) {
        termRepository.save(element);
    }

    @Override
    public void update(Term element) {
        termRepository.save(element);
    }

    @Override
    public void delete(Term element) {
        termRepository.delete(element);
    }

    @Override
    public void deleteById(Long id) {
        termRepository.delete(id);
    }

    @Override
    public Term save(Term element) {
        return termRepository.save(element);
    }
    
}
