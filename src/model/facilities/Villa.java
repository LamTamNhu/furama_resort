package model.facilities;

public class Villa extends Facility {
    private Type type;
    private Double poolArea;
    private Integer floorCount;

    public Villa(Type villaType, Double poolArea, Integer floorCount) {
        this.type = villaType;
        this.poolArea = poolArea;
        this.floorCount = floorCount;
    }

    public enum Type {
        ONE_STAR,
        TWO_STARS,
        THREE_STARS
    }

    public Villa() {
    }

    public Villa(String id, String name, Double area, Double fee, int maxCapacity, RentType rentType, Type type, Double poolArea, Integer floorCount) {
        super(id, name, area, fee, maxCapacity, rentType);
        this.type = type;
        this.poolArea = poolArea;
        this.floorCount = floorCount;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(Integer floorCount) {
        this.floorCount = floorCount;
    }
}
