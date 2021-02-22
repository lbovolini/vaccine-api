package com.github.lbovolini.vaccineapi.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Vaccination {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String vaccine;
    @Column(columnDefinition = "DATE")
    @NotNull
    private LocalDate date;
    @NotNull
    private Integer userId;

    public Vaccination() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
