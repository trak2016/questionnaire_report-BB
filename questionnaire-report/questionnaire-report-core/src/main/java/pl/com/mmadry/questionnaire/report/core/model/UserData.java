package pl.com.mmadry.questionnaire.report.core.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 * Class UserData
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Entity
@Table(name = "userdata", schema = "public")
@SuppressWarnings("PersistenceUnitPresent")
public class UserData extends BaseEntity {

    @Column(unique = true, insertable = false, updatable = false)
    @NotEmpty
    private String login;

    @OneToOne
    @JoinColumn(name = "login")
    private User user;

    @Size(max = 255)
    @Column
    private String name;

    @Size(max = 255)
    @Column
    private String surname;

    @Size(max = 255)
    @NotEmpty
    @Email
    @Column
    private String email;

    @Column(name = "registration_token")
    @Size(max = 255)
    private String registrationToken;

    @Size(max = 255)
    @Column(name = "reset_password_key")
    private String resetPasswordKey;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reset_password_key_generation_date")
    private Date resetPasswordKeyGenerationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_password_change_date")
    private Date lastPasswordChangeDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    @Column(name = "bad_login_count")
    private int badLoginCount = 0;

    @ManyToMany(mappedBy = "userDatas")
    private List<Questionnaire> questionnaires;
    
    @ManyToMany(mappedBy = "userDatas")
    private List<Answer> answers;
    
    public UserData() {

    }

    public UserData(Long id) {

        super(id);
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public String getLogin() {

        return login;
    }

    public void setLogin(String login) {

        this.login = login;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSurname() {

        return surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getResetPasswordKey() {

        return resetPasswordKey;
    }

    public void setResetPasswordKey(String resetPasswordKey) {

        this.resetPasswordKey = resetPasswordKey;
    }

    public Date getResetPasswordKeyGenerationDate() {

        return resetPasswordKeyGenerationDate;
    }

    public void setResetPasswordKeyGenerationDate(Date resetPasswordKeyGenerationDate) {

        this.resetPasswordKeyGenerationDate = resetPasswordKeyGenerationDate;
    }

    public Date getLastPasswordChangeDate() {

        return lastPasswordChangeDate;
    }

    public void setLastPasswordChangeDate(Date lastPasswordChangeDate) {

        this.lastPasswordChangeDate = lastPasswordChangeDate;
    }

    public Date getCreationDate() {

        return creationDate;
    }

    public void setCreationDate(Date creationDate) {

        this.creationDate = creationDate;
    }

    public Date getLastModifiedDate() {

        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {

        this.lastModifiedDate = lastModifiedDate;
    }

    public int getBadLoginCount() {

        return badLoginCount;
    }

    public void setBadLoginCount(int badLoginCount) {

        this.badLoginCount = badLoginCount;
    }

    public String getRegistrationToken() {

        return registrationToken;
    }

    public void setRegistrationToken(String registrationToken) {

        this.registrationToken = registrationToken;
    }

    public String getFullName() {

        return String.format("%s %s", name, surname);
    }

    public List<Questionnaire> getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(List<Questionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {

        return "UserData{" +
               "badLoginCount=" + badLoginCount +
               ", name='" + name + '\'' +
               ", surname='" + surname + '\'' +
               ", email='" + email + '\'' +
               ", registrationToken='" + registrationToken + '\'' +
               ", resetPasswordKey='" + resetPasswordKey + '\'' +
               ", resetPasswordKeyGenerationDate=" + resetPasswordKeyGenerationDate +
               ", lastPasswordChangeDate=" + lastPasswordChangeDate +
               ", creationDate=" + creationDate +
               ", lastModifiedDate=" + lastModifiedDate +
               ", login='" + login + '\'' +
               '}';
    }
}
