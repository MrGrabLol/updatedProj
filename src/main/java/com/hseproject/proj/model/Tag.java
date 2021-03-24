package com.hseproject.proj.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Tag {

    @Id
    private long id;

    private String value;

    public Tag (String value) {
        this.value = value;
    }

}
