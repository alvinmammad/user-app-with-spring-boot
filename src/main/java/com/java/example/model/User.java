package com.java.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.joda.LocalDateTimeParser;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //    @Column(name = "first_name", nullable = false)
    private String firstName;
    //    @Column(name = "last_name", nullable = false)
    private String lastName;
    //    @Column(name = "birthDate", nullable = false)

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    //    @Column(name = "citizen", nullable = false)
    private String citizen;
    //    @Column(name = "region", nullable = false)
    private String region;

    public User() {

    }

    public User(String firstName, String lastName, String citizen, String region, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.citizen = citizen;
        this.region = region;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCitizen() {
        return citizen;
    }

    public void setCitizen(String citizen) {
        this.citizen = citizen;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", citizen='" + citizen + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
