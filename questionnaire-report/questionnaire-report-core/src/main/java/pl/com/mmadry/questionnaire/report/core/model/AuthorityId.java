package pl.com.mmadry.questionnaire.report.core.model;

import java.io.Serializable;
import pl.com.mmadry.questionnaire.report.core.enums.Role;

/**
 * Class AuthorityId
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class AuthorityId implements Serializable {

    private String userName;

    private Role authority;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Role getAuthority() {
        return authority;
    }

    public void setAuthority(Role authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "AuthorityId{" +
               "userName='" + userName + '\'' +
               ", authority='" + authority + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AuthorityId that = (AuthorityId) o;

        return !(authority != null ? !authority.equals(that.authority) : that.authority != null)
               && !(userName != null ? !userName.equals(that.userName) : that.userName != null);
    }

    @Override
    public int hashCode() {

        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        return result;
    }
}
