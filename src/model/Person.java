package model;


public abstract class Person {
    private final String SEPARATOR = ",";
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

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public String getSEPARATOR() {
        return SEPARATOR;
    }

    public String convertAttributesToCsvFormat() {

        return name + SEPARATOR + birthDate + SEPARATOR + gender + SEPARATOR + idNumber
                + SEPARATOR + phoneNumber + SEPARATOR + email;
    }

    public void setAttributesFromCsvFormat(String csvString) {
        String[] attributeList = csvString.split(SEPARATOR);
        name = attributeList[0];
        birthDate = attributeList[1];
        gender = Gender.valueOf(attributeList[2]);
        idNumber = attributeList[3];
        phoneNumber = attributeList[4];
        email = attributeList[5];
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ", birthDate='" + birthDate + '\'' +
                        ", gender='" + gender + '\'' +
                        ", idNumber='" + idNumber + '\'' +
                        ", phoneNumber='" + phoneNumber + '\'' +
                        ", email='" + email;
    }

    public enum Gender {
        MALE,
        FEMALE
    }
}
