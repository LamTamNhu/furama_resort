package model.facilities;

public class Room extends Facility {
    private String complimentary;

    public Room() {
    }

    public Room(String id, String name, Double area, Double fee, int maxCapacity, RentType rentType, String complimentary) {
        super(id, name, area, fee, maxCapacity, rentType);
        this.complimentary = complimentary;
    }

    public String getComplimentary() {
        return complimentary;
    }

    public void setComplimentary(String complimentary) {
        this.complimentary = complimentary;
    }
}
