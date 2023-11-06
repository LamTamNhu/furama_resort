package model.human;

public class Customer extends Person {
    private String customerId;
    private CustomerTier customerTier;
    private String address;

    public Customer() {
    }

    public Customer(Person person, String customerId, CustomerTier customerTier, String address) {
        super(person.getName(), person.getBirthDate(), person.getGender(), person.getIdNumber(), person.getPhoneNumber(), person.getEmail());
        this.customerId = customerId;
        this.customerTier = customerTier;
        this.address = address;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerTier getCustomerTier() {
        return customerTier;
    }

    public void setCustomerTier(CustomerTier customerTier) {
        this.customerTier = customerTier;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String convertAttributesToCsvFormat() {
        return super.convertAttributesToCsvFormat() + getSEPARATOR() + customerId + getSEPARATOR() +
                customerTier + getSEPARATOR() + address;
    }

    @Override
    public void setAttributesFromCsvFormat(String csvString) {
        super.setAttributesFromCsvFormat(csvString);
        String[] attributeList = csvString.split(getSEPARATOR());
        customerId = attributeList[6];
        customerTier = CustomerTier.valueOf(attributeList[7]);
        address = attributeList[8];
    }

    @Override
    public String toString() {
        return
                "customerId='" + customerId + '\'' +
                        ", " + super.toString() +
                        ", customerTier=" + customerTier +
                        ", address='" + address + '\'';
    }

    public enum CustomerTier {
        DIAMOND,
        PLATINUM,
        GOLD,
        SILVER,
        MEMBER
    }
}
