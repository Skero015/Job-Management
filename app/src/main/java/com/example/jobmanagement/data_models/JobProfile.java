package com.example.jobmanagement.data_models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity (tableName = "Job Profile", indices = {@Index(value = {"email", "identityNumber"},
        unique = true)})

public class JobProfile
{
    @PrimaryKey
    @ColumnInfo (name = "id")
    private long id;

    @ColumnInfo (name = "email")
    private String email;
    @ColumnInfo (name = "password")
    private String password;
    @ColumnInfo (name = "name")
    private String name;
    @ColumnInfo (name = "surname")
    private String surname;
    @ColumnInfo (name = "cellphone")
    private String cellphone;
    @ColumnInfo (name = "identityNumber")
    private String identityNumber;
    @ColumnInfo (name = "qualification")
    private String qualification;
    @ColumnInfo (name = "education")
    private String education;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
