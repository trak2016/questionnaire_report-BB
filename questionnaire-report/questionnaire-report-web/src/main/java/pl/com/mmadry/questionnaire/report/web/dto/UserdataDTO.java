package pl.com.mmadry.questionnaire.report.web.dto;

import java.util.Objects;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class UserdataDTO {
    
    private Long id;
    private String name;
    private String surname;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserdataDTO)) return false;
        UserdataDTO userdataDTO = (UserdataDTO) o;
        return Objects.equals(id, userdataDTO.getId());
    }

    @Override
    public int hashCode() {
        int result = getId().intValue();
        result = 31 * result;
        return result;
    }
}
