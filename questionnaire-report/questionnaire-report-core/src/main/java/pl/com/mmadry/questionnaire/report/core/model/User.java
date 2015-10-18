package pl.com.mmadry.questionnaire.report.core.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class User
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Entity
@Table(name = "users", schema = "public")
@SuppressWarnings("PersistenceUnitPresent")
public class User implements Serializable {

    @Id
    private String username;

    private boolean enabled;

    private String password;

    public User() {

    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public boolean isEnabled() {

        return enabled;
    }

    public void setEnabled(boolean enabled) {

        this.enabled = enabled;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    @Override
    public String toString() {

        return "User{" + "username=" + username + ", enabled=" + enabled + '}';
    }
}
