package com.example.glassshop.models;

//import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import javax.persistence.*;
//import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=5, max=15, message="Please choose a username that's 5-15 characters long.")
    private String username;

    @NotNull
    @Size(min=8, max=15, message="Please choose a password that's 8-15 characters long.")
    private String password;

    private String passwordVerify;

    public User(String username, String password, String passwordVerify) {
        this.username = username;
        this.password = password;
        this.passwordVerify = passwordVerify;
    }

    public User() {}

    public int getId() { return id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPasswordVerify() { return passwordVerify; }
    public void setPasswordVerify(String passwordVerify) { this.passwordVerify = passwordVerify; }

    //private Set<Role> roles;
    //@ManyToMany
    //@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    //public Set<Role> getRoles() {
        //return roles;
   // }

    //public void setRoles(Set<Role> roles) {
       // this.roles = roles;
   // }
}