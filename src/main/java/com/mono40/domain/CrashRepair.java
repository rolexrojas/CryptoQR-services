package com.mono40.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CrashRepair implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean ignitionSystemRepair;
    private boolean coolingSystemRepair;
    private boolean steeringSystemRepair;
    private boolean transmissionSystemRepair;
    private boolean exhaustSystemRepair;
    private boolean suspensionSystemRepair;
    private boolean fuelSupplySystemRepair;
    private boolean brakingSystemRepair;
    private boolean gasolineEngineRepair;
    private boolean electricalSystemRepair;

    public CrashRepair() {
    }

    public boolean isIgnitionSystemRepair() {
        return ignitionSystemRepair;
    }

    public void setIgnitionSystemRepair(boolean ignitionSystemRepair) {
        this.ignitionSystemRepair = ignitionSystemRepair;
    }

    public boolean isCoolingSystemRepair() {
        return coolingSystemRepair;
    }

    public void setCoolingSystemRepair(boolean coolingSystemRepair) {
        this.coolingSystemRepair = coolingSystemRepair;
    }

    public boolean isSteeringSystemRepair() {
        return steeringSystemRepair;
    }

    public void setSteeringSystemRepair(boolean steeringSystemRepair) {
        this.steeringSystemRepair = steeringSystemRepair;
    }

    public boolean isTransmissionSystemRepair() {
        return transmissionSystemRepair;
    }

    public void setTransmissionSystemRepair(boolean transmissionSystemRepair) {
        this.transmissionSystemRepair = transmissionSystemRepair;
    }

    public boolean isExhaustSystemRepair() {
        return exhaustSystemRepair;
    }

    public void setExhaustSystemRepair(boolean exhaustSystemRepair) {
        this.exhaustSystemRepair = exhaustSystemRepair;
    }

    public boolean isSuspensionSystemRepair() {
        return suspensionSystemRepair;
    }

    public void setSuspensionSystemRepair(boolean suspensionSystemRepair) {
        this.suspensionSystemRepair = suspensionSystemRepair;
    }

    public boolean isFuelSupplySystemRepair() {
        return fuelSupplySystemRepair;
    }

    public void setFuelSupplySystemRepair(boolean fuelSupplySystemRepair) {
        this.fuelSupplySystemRepair = fuelSupplySystemRepair;
    }

    public boolean isBrakingSystemRepair() {
        return brakingSystemRepair;
    }

    public void setBrakingSystemRepair(boolean brakingSystemRepair) {
        this.brakingSystemRepair = brakingSystemRepair;
    }

    public boolean isGasolineEngineRepair() {
        return gasolineEngineRepair;
    }

    public void setGasolineEngineRepair(boolean gasolineEngineRepair) {
        this.gasolineEngineRepair = gasolineEngineRepair;
    }

    public boolean isElectricalSystemRepair() {
        return electricalSystemRepair;
    }

    public void setElectricalSystemRepair(boolean electricalSystemRepair) {
        this.electricalSystemRepair = electricalSystemRepair;
    }
}
