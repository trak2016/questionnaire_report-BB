package pl.com.mmadry.questionnaire.report.core.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public enum Role {
    ROLE_USER, ROLE_ADMIN, ROLE_SYS_ADMIN;

    private static final List<Role> ROLE_HIERARCHY = new ArrayList<>();

    static {
        ROLE_HIERARCHY.add(0, ROLE_USER);
        ROLE_HIERARCHY.add(1, ROLE_ADMIN);
        ROLE_HIERARCHY.add(2, ROLE_SYS_ADMIN);
    }

    public boolean isHigherOrEqual(Role role) {
        return ROLE_HIERARCHY.indexOf(this) >= ROLE_HIERARCHY.indexOf(role);
    }
}
