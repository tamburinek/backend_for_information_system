package cz.cvut.fel.ear.instakos.model.enums;

import java.util.Set;

public enum Roles {
    ADMIN("ROLE_ADMIN"),BLOCKED("ROLE_BLOCKED"), STUDENT("ROLE_STUDENT"), GUEST("ROLE_GUEST"), TEACHER("ROLE_TEACHER"), LOGOUT("ROLE_LOGOUT");

    private final String name;

    Roles(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

