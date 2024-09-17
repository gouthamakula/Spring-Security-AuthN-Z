package dev.akula.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.io.Serial;
import java.time.Instant;
import java.util.Collection;
import java.util.List;


import static dev.akula.entities.SbGrantAuthority.USER;

@Table(name = "users")
@Entity
@Data
public class User implements UserDetails {
    @Serial
    private static final long serialVersionUID = 1001L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, length = 100, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Instant createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;
    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(USER.toGrantedAuthority());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
         return email;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

}
