package pl.com.mmadry.questionnaire.report.web.form.registration;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Class RegistrationForm
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class RegistrationForm {

    @NotEmpty(message = "Wymagane")
    @Email(message = "Podaj poprawny adres e-mail")
    private String email;

    @NotEmpty(message = "Wymagane")
    private String password;

    @NotEmpty(message = "Wymagane")
    private String password2;

    public RegistrationForm() {

    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getPassword2() {

        return password2;
    }

    public void setPassword2(String password2) {

        this.password2 = password2;
    }
}
