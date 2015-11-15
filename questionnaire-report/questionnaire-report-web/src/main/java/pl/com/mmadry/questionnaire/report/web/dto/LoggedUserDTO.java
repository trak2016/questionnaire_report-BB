package pl.com.mmadry.questionnaire.report.web.dto;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class LoggedUserDTO {

    private Long id;
    private String name;
    private String surname;
    private String loginName;
    private Set<String> roleSet = new HashSet<>();

    public LoggedUserDTO(Long id, String name, String surname, String loginName) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.loginName = loginName;
    }

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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Set<String> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<String> roleSet) {
        this.roleSet = roleSet;
    }

    @Override
    public String toString() {
        return "LoggedUserDTO{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", loginName=" + loginName + ", roleSet=" + roleSet + '}';
    }
}
