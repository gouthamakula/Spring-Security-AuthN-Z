package dev.akula.entities;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.EnumSet;

@Getter
public enum SbGrantAuthority {
    USER("USER"),
    ADMIN("U_ADMIN"),
    SUPER_ADMIN("U_G_SUPER_ADMIN"),
    GROUP_USER("G_USER"),
    GROUP_ADMIN("G_ADMIN"),
    GROUP_SUPER_ADMIN("G_SUPER_ADMIN"),
    TECH_SUPPORT("T_SUPPORT"),
    TECH_ADMIN("T_ADMIN"),
    CUSTOMER_SUPPORT("C_SUPPORT"),
    CUSTOMER_ADMIN("C_ADMIN"),
    CUSTOMER_USER("C_USER");

    public static final EnumSet<SbGrantAuthority> ALL_ROLES = EnumSet.allOf(SbGrantAuthority.class);

    public static final EnumSet<SbGrantAuthority> ALL_GROUPS_ROLES = EnumSet.of(GROUP_USER, GROUP_ADMIN, GROUP_SUPER_ADMIN);
    public static final EnumSet<SbGrantAuthority> ALL_TECH_ROLES = EnumSet.of(TECH_SUPPORT, TECH_ADMIN);
    public static final EnumSet<SbGrantAuthority> ALL_CUSTOMER_ROLES = EnumSet.of(CUSTOMER_SUPPORT, CUSTOMER_ADMIN, CUSTOMER_USER);
    public static final EnumSet<SbGrantAuthority> ALL_USER_ROLES = EnumSet.of(USER, ADMIN, SUPER_ADMIN);

    private final String authority;

    SbGrantAuthority(String authority) {
        this.authority = authority;
    }

    public GrantedAuthority toGrantedAuthority() {
        return new SimpleGrantedAuthority(authority);
    }
}
