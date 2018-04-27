package org.hassen.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(name = "account")
public class Account implements Serializable {

    @Column(name = "id")
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(name = "username",nullable = false)
    private String username;

    @NotEmpty
    @Column(name = "password",nullable = false)
    private String password;

    @NotEmpty
    @Column(name = "fullName",nullable = false)
    private String fullName;

    public Account(){

    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
