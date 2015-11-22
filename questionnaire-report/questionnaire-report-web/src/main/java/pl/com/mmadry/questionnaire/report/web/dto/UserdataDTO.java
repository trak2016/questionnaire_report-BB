package pl.com.mmadry.questionnaire.report.web.dto;

import java.util.Date;
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
    private Date creationDate;
    private Boolean enabled;

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    @Override
    public String toString() {
        return "UserdataDTO{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", creationDate=" + creationDate + ", enabled=" + enabled + '}';
    }
}
