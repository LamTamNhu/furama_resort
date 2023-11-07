package model.facilities;

public class House extends Facility {
    private HouseType houseType;
    private Integer floorCount;

    public House(HouseType houseType, int floorCount) {
        this.houseType = houseType;
        this.floorCount = floorCount;
    }

    public enum HouseType {
        SUITE,
        STUDIO,
        EXECUTIVE,
        PRESIDENTIAL
    }

    public House() {
    }

    public House(String id, String name, Double area, Double fee, int maxCapacity, RentType rentType, HouseType type, Integer floorCount) {
        super(id, name, area, fee, maxCapacity, rentType);
        this.houseType = type;
        this.floorCount = floorCount;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    public Integer getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(Integer floorCount) {
        this.floorCount = floorCount;
    }

    @Override
    public String toString() {
        return super.toString() +
               " | Type: " + houseType +
               " | FloorCount: " + floorCount;
    }
}
