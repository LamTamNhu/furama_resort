package model;

import utils.enums.CustomerTier;
import utils.enums.Gender;

public class Customer extends Person {
    private String customerId;
    private CustomerTier customerTier;
    private String address;

    public Customer() {
    }

    public Customer(Person person, String customerId, CustomerTier customerTier, String address) {
        super(person.getName(), person.getBirthDate(), person.getGender(), person.getIdNumber(), person.getPhoneNumber(), person.getEmail());

    }

    public Customer(String name, String birthDate, Gender gender, String idNumber, String phoneNumber, String email, String customerId, CustomerTier customerTier, String address) {
        super(name, birthDate, gender, idNumber, phoneNumber, email);
        this.customerId = customerId;
        this.customerTier = customerTier;
        this.address = address;
    }

    public Customer(String customerId, CustomerTier customerTier, String address) {
        this.customerId = customerId;
        this.customerTier = customerTier;
        this.address = address;
    }
}
