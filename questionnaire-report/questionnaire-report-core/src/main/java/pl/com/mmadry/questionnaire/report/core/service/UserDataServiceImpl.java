package pl.com.mmadry.questionnaire.report.core.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.mmadry.questionnaire.report.core.model.UserData;
import pl.com.mmadry.questionnaire.report.core.repository.UserDataRepository;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Service
@Transactional
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private UserDataRepository userDataRepository;

    @Override
    @Transactional(readOnly = true)
    public UserData getElement(Long id) {
        return userDataRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserData> getElements() {
        return userDataRepository.findAll();
    }

    @Override
    public void add(UserData element) {
        userDataRepository.save(element);
    }

    @Override
    public void update(UserData element) {
        userDataRepository.save(element);
    }

    @Override
    public void delete(UserData element) {
        userDataRepository.delete(element);
    }

    @Override
    public void deleteById(Long id) {
        userDataRepository.delete(id);
    }

    @Override
    public UserData save(UserData element) {
        return userDataRepository.save(element);
    }

}
