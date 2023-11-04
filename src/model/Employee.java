package model;

import utils.enums.Gender;
import utils.enums.Position;
import utils.enums.Qualification;

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
    public String toString() {
        return super.toString() + "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", qualification='" + qualification + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
