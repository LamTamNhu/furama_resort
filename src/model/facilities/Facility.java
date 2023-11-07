package model.facilities;

public abstract class Facility {
    private String id;
    private String name;
    private Double area;
    private Double fee;
    private Integer maxCapacity;
    private RentType rentType;

    public enum RentType {
        YEAR,
        MONTH,
        DAY,
        HOUR
    }

    public Facility() {
    }

    public Facility(String id, String name, Double area, Double fee, int maxCapacity, RentType rentType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.fee = fee;
        this.maxCapacity = maxCapacity;
        this.rentType = rentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Area: " + area + " | Fee: " + fee + "$ | Max capacity: " + maxCapacity + " persons | Rent type: " + rentType + " | ";
    }
}
