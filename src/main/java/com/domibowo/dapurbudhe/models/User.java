package com.domibowo.dapurbudhe.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Size(min = 8, max = 12, message = "Minimum length is 8 and maximum is 12")
    @Pattern(regexp = "^(?=\\S+$).{8,12}$", message = "No whitespace allowed")
    @NotNull(message = "Username should not be null")
    @Column(unique = true)
    private String username;

    @Email(message = "Email should be valid")
    @NotNull(message = "Email should not be null")
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,12}$", message = "Password at least contains: " +
            "a digit, an uppercase, a lowercase, no whitespace")
    @Size(min = 8, max = 12, message = "Minimum length is 8 and maximum is 12")
    @NotNull(message = "Password should not be null")
    private String password;

    public User(String id, @Size(min = 8, max = 12, message = "Minimum length is 8 and maximum is 12") @Pattern(regexp = "^(?=\\S+$).{8,12}$", message = "No whitespace allowed") @NotNull(message = "Username should not be null") String username, @Email(message = "Email should be valid") @NotNull(message = "Email should not be null") String email, @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,12}$", message = "Password at least contains: " +
            "a digit, an uppercase, a lowercase, no whitespace") @Size(min = 8, max = 12, message = "Minimum length is 8 and maximum is 12") @NotNull(message = "Password should not be null") String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
