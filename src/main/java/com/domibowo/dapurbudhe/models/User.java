package com.domibowo.dapurbudhe.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.IDENTITY)
    private String id;

    @Min(value = 8, message = "Username minimum length is 8")
    @Max(value = 12, message = "Username maximum length is 12")
    @NotNull
    @Column(unique = true)
    private String username;

    @Email
    @NotNull
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,12}$", message = "Password at least contains: " +
            "a digit, an uppercase, a lowercase, no whitespace. Minimum length is 8 and maximum is 12")
    private String password;

    public User(String id, @Min(value = 8, message = "Username minimum length is 8") @Max(value = 12, message = "Username maximum length is 12") @NotNull String username, @Email @NotNull String email, @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,12}$", message = "Password at least contains: " +
            "a digit, an uppercase, a lowercase, no whitespace. Minimum length is 8 and maximum is 12") String password) {
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
