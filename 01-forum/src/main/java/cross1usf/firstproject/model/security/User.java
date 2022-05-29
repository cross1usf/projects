package cross1usf.firstproject.model.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message =  "Username required")
    @Column(unique = true)
    private String username;
    @NotBlank(message = "Name Required")
    private String firstName;
    @NotBlank(message = "lastName Required")
    private String lastName;
    @NotBlank(message = "Email required")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "Password Required")
    private String password;


    @Builder.Default
    private Instant dateCreated = Instant.now();

    @Builder.Default
    private Boolean enabled = false; //Must Confirm account... with say email.
    @Builder.Default
    private Boolean accountNonExpired = true;
    @Builder.Default
    private Boolean accountNonLocked = true;
    @Builder.Default
    private Boolean credentialsNonExpired = true;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
    joinColumns = {@JoinColumn(name="user_id", referencedColumnName = "id"),},
    inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")})
    private Set<Role> roles = new HashSet<>();


    public void addRole(Role role) {
        this.roles.add(role);
    }

}
