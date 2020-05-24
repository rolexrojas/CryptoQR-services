package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.Transient;

public class DeviceInformationType {
    
    private String manufacturer;
    private String serial;
    private String fingerprint;
    private String device;
    private String display;
    private String board;
    private String bootloader;
    private String brand;
    private String hardware;
    private String model;
    private String name;
    private String imei;

    @JsonProperty("system-name")
    private String systemName;

    @JsonProperty("system-version")
    private String systemVersion;

    @JsonProperty("localized-model")
    private String localizedModel;

    @JsonProperty("identifier-for-vendor")
    private String identifierForVendor;

    @Transient
    private boolean bitOne;

    @Transient
    private boolean bitTwo;


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getBootloader() {
        return bootloader;
    }

    public void setBootloader(String bootloader) {
        this.bootloader = bootloader;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getLocalizedModel() {
        return localizedModel;
    }

    public void setLocalizedModel(String localizedModel) {
        this.localizedModel = localizedModel;
    }

    public String getIdentifierForVendor() {
        return identifierForVendor;
    }

    public void setIdentifierForVendor(String identifierForVendor) {
        this.identifierForVendor = identifierForVendor;
    }

    public boolean isBitOne() {
        return bitOne;
    }

    public void setBitOne(boolean bitOne) {
        this.bitOne = bitOne;
    }

    public boolean isBitTwo() {
        return bitTwo;
    }

    public void setBitTwo(boolean bitTwo) {
        this.bitTwo = bitTwo;
    }
}
