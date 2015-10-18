package pl.com.mmadry.questionnaire.report.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import pl.com.mmadry.questionnaire.report.core.enums.Role;
import pl.com.mmadry.questionnaire.report.core.model.Authority;
import pl.com.mmadry.questionnaire.report.core.model.AuthorityId;
import pl.com.mmadry.questionnaire.report.core.repository.AuthorityRepository;


/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public List<Authority> findByUserName(String userName) {
        return authorityRepository.findByUserName(userName);
    }

    @Override
    public Authority getElement(AuthorityId id) {
        return authorityRepository.findOne(id);
    }

    @Override
    public List<Authority> getElements() {
        return authorityRepository.findAll();
    }

    @Override
    public void add(Authority element) {
        authorityRepository.save(element);
    }

    @Override
    public void update(Authority element) {
        authorityRepository.save(element);
    }

    @Override
    public void delete(Authority element) {
        authorityRepository.delete(element);
    }

    @Override
    public void deleteById(AuthorityId id) {
        authorityRepository.delete(id);
    }

    @Override
    public Authority save(Authority element) {
        return authorityRepository.save(element);
    }

    @Override
    public Authority findByUserAndRole(String username, Role role) {
        return authorityRepository.findByUserNameAndAuthority(username, role);
    }
}
