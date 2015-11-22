package pl.com.mmadry.questionnaire.report.core.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.mmadry.questionnaire.report.core.enums.Role;
import pl.com.mmadry.questionnaire.report.core.exception.NoAuthInfoAvailableException;
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

    @Autowired(required = false)
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsManager userDetailsManager;

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

    @Override
    public void add(UserData element, Role... roles) {
        GrantedAuthority[] grantedAuthorities = new GrantedAuthority[roles.length];
        int i = 0;
        for (Role role : roles) {
            grantedAuthorities[i++] = new SimpleGrantedAuthority(role.toString());
        }

        List<GrantedAuthority> auth = Arrays.asList(grantedAuthorities);
        User user = new User(element.getUser().getUsername(),
                encodePassword(element.getUser().getPassword()), false, true, true,
                true, auth);
        userDetailsManager.createUser(user);

        element.setCreationDate(new Date());

        userDataRepository.saveAndFlush(element);
    }

    @Override
    public void enableUser(long id) {
        UserData user = userDataRepository.findOne(id);
        user.getUser().setEnabled(true);
        userDataRepository.save(user);
    }

    @Override
    public UserData findByToken(String token) {
        return userDataRepository.findByRegistrationToken(token);
    }

    @Override
    @Transactional(readOnly = true)
    public UserData findByEmail(String email) {
        return userDataRepository.findByEmail(email);
    }
    
    private String encodePassword(String passwordPlainText) {

        if (passwordEncoder != null) {
            return passwordEncoder.encode(passwordPlainText);
        }
        return passwordPlainText;
    }
    
    @Override
    @Transactional(readOnly = true)
    public String getLoggedUserLogin() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                return userDetails.getUsername();

            }
        }

        throw new NoAuthInfoAvailableException("Brak informacji o zalogowanym użytkowniku");
    }

    @Override
    @Transactional(readOnly = true)
    public UserData getLoggedUserData() {

        String login = getLoggedUserLogin();

        UserData userData = findByUsername(login);

        if (userData == null) {
            throw new NoAuthInfoAvailableException("Brak informacji o zalogowanym użytkowniku");
        }

        return userData;
    }
    
    @Override
    @Transactional(readOnly = true)
    public UserData findByUsername(String username) {
        return userDataRepository.findByUsername(username);
    }

    @Override
    public void enableDisableUser(Long id) {
        UserData user = userDataRepository.findOne(id);
        user.getUser().setEnabled(!user.getUser().isEnabled());
        userDataRepository.save(user);
    }


}
