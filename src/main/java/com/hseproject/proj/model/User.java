package com.hseproject.proj.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.math3.util.Precision;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private AuthModel authModel;

    private String phone;

    private Double bonus;

    public User(AuthModel authModel, String phone) {
        this.authModel = authModel;
        this.phone = phone;
        bonus = 0D;
    }

    public void setBonus(Double bonus) {
        this.bonus = Precision.round(bonus, 2);
    }
}
