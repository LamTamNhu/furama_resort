package model;

public class House extends Facility {
    private Type type;
    private Integer floorCount;

    public enum Type {
        SUITE,
        STUDIO,
        EXECUTIVE,
        PRESIDENTIAL
    }

    public House() {
    }

    public House(String id, String name, Double area, Double fee, int maxCapacity, RentType rentType, Type type, Integer floorCount) {
        super(id, name, area, fee, maxCapacity, rentType);
        this.type = type;
        this.floorCount = floorCount;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(Integer floorCount) {
        this.floorCount = floorCount;
    }
}
