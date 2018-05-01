package com.joseph.dogdaycare.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "entries")
public class DogDaycareEntry {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "entry_id")
    private Integer id;
    @NotEmpty
    private String owner;
    @NotEmpty
    private String breed;
    @NotEmpty
    private String date;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}

