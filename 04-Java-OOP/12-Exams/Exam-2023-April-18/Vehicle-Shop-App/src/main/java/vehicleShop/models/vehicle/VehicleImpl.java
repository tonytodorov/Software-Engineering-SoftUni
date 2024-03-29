package vehicleShop.models.vehicle;

import vehicleShop.common.ExceptionMessages;

import static vehicleShop.common.ExceptionMessages.*;

public class VehicleImpl implements Vehicle {

    private String name;
    private int strengthRequired;

    public VehicleImpl(String name, int strengthRequired) {
        this.setName(name);
        this.setStrengthRequired(strengthRequired);
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new IllegalArgumentException(VEHICLE_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    private void setStrengthRequired(int strengthRequired) {
        if (strengthRequired < 0) {
            throw new IllegalArgumentException(VEHICLE_STRENGTH_LESS_THAN_ZERO);
        }

        this.strengthRequired = strengthRequired;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStrengthRequired() {
        return strengthRequired;
    }

    @Override
    public boolean reached() {
        return this.strengthRequired == 0;
    }

    @Override
    public void making() {
        this.strengthRequired -= 5;

        if (this.strengthRequired < 0) {
            this.strengthRequired = 0;
        }
    }
}
