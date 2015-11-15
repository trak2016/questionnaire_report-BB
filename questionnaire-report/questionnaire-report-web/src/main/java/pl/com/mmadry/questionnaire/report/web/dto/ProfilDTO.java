package pl.com.mmadry.questionnaire.report.web.dto;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class ProfilDTO {
    
    private String email;
    private String surname;
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProfilDTO{" + "email=" + email + ", surname=" + surname + ", name=" + name + '}';
    }

}
