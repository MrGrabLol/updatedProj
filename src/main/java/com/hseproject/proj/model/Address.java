package com.hseproject.proj.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private long id;

    private String name;

    private String address;

    private String photoId;

    private String phone;

    @ElementCollection
    @CollectionTable
    private List<String> worktime;
}
