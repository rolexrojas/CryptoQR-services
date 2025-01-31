package com.mono40.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Maintenance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String eventKey;
    private boolean oilChange;
    private boolean oilFilterChange;
    private boolean transmissionFluidChange;
    private boolean brakeFluidChange;
    private boolean steeringFluidChange;
    private boolean coolantFluidChange;
    private boolean wipeWaterCheck;
    private boolean batteryWaterChange;
    private boolean radiatorHosesCheck;
    private boolean heaterHosesCheck;
    private boolean airCondHosesCheck;
    private boolean airFilterChange;
    private boolean tirePressureCheck;
    private boolean tireWearCheck;
    private boolean wipersCheck;
    private boolean headLampAlignmentCheck;
    private boolean seatBeltCheck;
    private boolean parkingBreakCheck;

    public Maintenance() {
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public boolean isOilChange() {
        return oilChange;
    }

    public void setOilChange(boolean oilChange) {
        this.oilChange = oilChange;
    }

    public boolean isOilFilterChange() {
        return oilFilterChange;
    }

    public void setOilFilterChange(boolean oilFilterChange) {
        this.oilFilterChange = oilFilterChange;
    }

    public boolean isTransmissionFluidChange() {
        return transmissionFluidChange;
    }

    public void setTransmissionFluidChange(boolean transmissionFluidChange) {
        this.transmissionFluidChange = transmissionFluidChange;
    }

    public boolean isBrakeFluidChange() {
        return brakeFluidChange;
    }

    public void setBrakeFluidChange(boolean brakeFluidChange) {
        this.brakeFluidChange = brakeFluidChange;
    }

    public boolean isSteeringFluidChange() {
        return steeringFluidChange;
    }

    public void setSteeringFluidChange(boolean steeringFluidChange) {
        this.steeringFluidChange = steeringFluidChange;
    }

    public boolean isCoolantFluidChange() {
        return coolantFluidChange;
    }

    public void setCoolantFluidChange(boolean coolantFluidChange) {
        this.coolantFluidChange = coolantFluidChange;
    }

    public boolean isWipeWaterCheck() {
        return wipeWaterCheck;
    }

    public void setWipeWaterCheck(boolean wipeWaterCheck) {
        this.wipeWaterCheck = wipeWaterCheck;
    }

    public boolean isBatteryWaterChange() {
        return batteryWaterChange;
    }

    public void setBatteryWaterChange(boolean batteryWaterChange) {
        this.batteryWaterChange = batteryWaterChange;
    }

    public boolean isRadiatorHosesCheck() {
        return radiatorHosesCheck;
    }

    public void setRadiatorHosesCheck(boolean radiatorHosesCheck) {
        this.radiatorHosesCheck = radiatorHosesCheck;
    }

    public boolean isHeaterHosesCheck() {
        return heaterHosesCheck;
    }

    public void setHeaterHosesCheck(boolean heaterHosesCheck) {
        this.heaterHosesCheck = heaterHosesCheck;
    }

    public boolean isAirCondHosesCheck() {
        return airCondHosesCheck;
    }

    public void setAirCondHosesCheck(boolean airCondHosesCheck) {
        this.airCondHosesCheck = airCondHosesCheck;
    }

    public boolean isAirFilterChange() {
        return airFilterChange;
    }

    public void setAirFilterChange(boolean airFilterChange) {
        this.airFilterChange = airFilterChange;
    }

    public boolean isTirePressureCheck() {
        return tirePressureCheck;
    }

    public void setTirePressureCheck(boolean tirePressureCheck) {
        this.tirePressureCheck = tirePressureCheck;
    }

    public boolean isTireWearCheck() {
        return tireWearCheck;
    }

    public void setTireWearCheck(boolean tireWearCheck) {
        this.tireWearCheck = tireWearCheck;
    }

    public boolean isWipersCheck() {
        return wipersCheck;
    }

    public void setWipersCheck(boolean wipersCheck) {
        this.wipersCheck = wipersCheck;
    }

    public boolean isHeadLampAlignmentCheck() {
        return headLampAlignmentCheck;
    }

    public void setHeadLampAlignmentCheck(boolean headLampAlignmentCheck) {
        this.headLampAlignmentCheck = headLampAlignmentCheck;
    }

    public boolean isSeatBeltCheck() {
        return seatBeltCheck;
    }

    public void setSeatBeltCheck(boolean seatBeltCheck) {
        this.seatBeltCheck = seatBeltCheck;
    }

    public boolean isParkingBreakCheck() {
        return parkingBreakCheck;
    }

    public void setParkingBreakCheck(boolean parkingBreakCheck) {
        this.parkingBreakCheck = parkingBreakCheck;
    }
}
