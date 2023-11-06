package model.human;

public class Employee extends Person {
    private String employeeId;
    private Qualification qualification;
    private Position position;
    private Double salary;

    public Employee() {
    }

    public Employee(Person person, String employeeId, Qualification qualification, Position position, Double salary) {
        super(person.getName(), person.getBirthDate(), person.getGender(), person.getIdNumber(), person.getPhoneNumber(), person.getEmail());
        this.employeeId = employeeId;
        this.qualification = qualification;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String name, String birthDate, Gender gender, String idNumber, String phoneNumber,
                    String email, String employeeId, Qualification qualification, Position position, Double salary) {
        super(name, birthDate, gender, idNumber, phoneNumber, email);
        this.employeeId = employeeId;
        this.qualification = qualification;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String employeeId, Qualification qualification, Position position, Double salary) {
        this.employeeId = employeeId;
        this.qualification = qualification;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String convertAttributesToCsvFormat() {
        return super.convertAttributesToCsvFormat() + getSEPARATOR() + employeeId + getSEPARATOR() + qualification +
                getSEPARATOR() + position + getSEPARATOR() + salary;
    }

    @Override
    public void setAttributesFromCsvFormat(String csvString) {
        super.setAttributesFromCsvFormat(csvString);
        String[] attributeList = csvString.split(getSEPARATOR());
        employeeId = attributeList[6];
        qualification = Qualification.valueOf(attributeList[7]);
        position = Position.valueOf(attributeList[8]);
        salary = Double.valueOf(attributeList[9]);
    }

    @Override
    public String toString() {
        return "employeeId='" + employeeId + '\'' + ", " +
                super.toString() +
                ", qualification='" + qualification + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary;
    }

    public enum Position {
        RECEPTIONIST,
        SERVER,
        EXPERT,
        SUPERVISOR,
        MANAGER,
        DIRECTOR
    }

    public enum Qualification {
        INTERMEDIATE,
        COLLEGE,
        UNIVERSITY,
        POSTGRADUATE
    }
}
