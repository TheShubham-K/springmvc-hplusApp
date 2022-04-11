package com.shubham.springmvc.beans;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Size(min = 6, message="{username.msg}")
    private String username;

    @Pattern(regexp="((?=.*[A-Z]).{6,10})",
            message="{password.msg}")
    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message="{activity.msg}")
    private String activity;

    @NotEmpty(message="{firstname.msg}")
    private String firstName;

    private String lastName;

    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private Date dateOfBirth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender  gender) {
        this.gender = gender;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
