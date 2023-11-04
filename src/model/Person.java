package model;


import utils.enums.Gender;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String birthDate;
    private Gender gender;
    private String idNumber;
    private String phoneNumber;
    private String email;

    public Person(String name, String birthDate, Gender gender, String idNumber, String phoneNumber, String email) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(String gender) {
        switch (gender) {
            case "M":
                this.gender = Gender.MALE;
                break;
            case "F":
                this.gender = Gender.FEMALE;
                break;
            default:
                System.out.println("Wrong gender String input!");
        }
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", gender='" + gender + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
