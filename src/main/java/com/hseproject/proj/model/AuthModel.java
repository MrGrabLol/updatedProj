package com.hseproject.proj.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "auth_model")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthModel {

    @Id
    private Long id;

    private String login;

    private String password;

    public AuthModel(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
