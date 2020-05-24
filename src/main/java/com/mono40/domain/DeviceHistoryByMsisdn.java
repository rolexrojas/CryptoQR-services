package com.mono40.domain;
/*
import com.mono40.util.ConstantsUtil.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class DeviceHistoryByMsisdn implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account account;

    @Column(nullable = false)
    private Long msisdn;

    @Column(nullable = false, length = 50)
    private String imei;

    private String manufacture;
    private String fingerprint;
    private String deviceName;
    private String display;
    private String bootloader;
    private String board;
    private String brand;
    private String hardware;
    private String model;
    private String serial;
    private String iosName;
    private String systemName;
    private String systemVersion;
    private String localizedModel;
    private String identifierForVendor;
    private Boolean statusIosDeviceBitOne;
    private Boolean statusIosDeviceBitTwo;
    private Date dateUpdateChangeDevice = new Date();


    @Enumerated(EnumType.STRING)
    private OS os;

    public DeviceHistoryByMsisdn deviceHistoryByMsisdn(Device device){
        this.account = device.getAccount();
        this.msisdn = device.getMsisdn();
        this.imei = device.getImei();
        this.manufacture = device.getManufacture();
        this.fingerprint = device.getFingerprint();
        this.deviceName = device.getDeviceName();
        this.display = device.getDisplay();
        this.bootloader = device.getBootloader();
        this.board = device.getBoard();
        this.brand = device.getBrand();
        this.hardware = device.getHardware();
        this.model = device.getModel();
        this.serial = device.getSerial();
        this.iosName = device.getIosName();
        this.systemName = device.getSystemName();
        this.systemVersion = device.getSystemVersion();
        this.localizedModel = device.getLocalizedModel();
        this.identifierForVendor = device.getIdentifierForVendor();
        this.statusIosDeviceBitOne = device.getStatusIosDeviceBitOne();
        this.statusIosDeviceBitTwo = device.getStatusIosDeviceBitTwo();
        this.os = device.getOs();
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(Long msisdn) {
        this.msisdn = msisdn;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getBootloader() {
        return bootloader;
    }

    public void setBootloader(String bootloader) {
        this.bootloader = bootloader;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
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

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getIosName() {
        return iosName;
    }

    public void setIosName(String iosName) {
        this.iosName = iosName;
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

    public Boolean getStatusIosDeviceBitOne() {
        return statusIosDeviceBitOne;
    }

    public void setStatusIosDeviceBitOne(Boolean statusIosDeviceBitOne) {
        this.statusIosDeviceBitOne = statusIosDeviceBitOne;
    }

    public Boolean getStatusIosDeviceBitTwo() {
        return statusIosDeviceBitTwo;
    }

    public void setStatusIosDeviceBitTwo(Boolean statusIosDeviceBitTwo) {
        this.statusIosDeviceBitTwo = statusIosDeviceBitTwo;
    }

    public Date getDateUpdateChangeDevice() {
        return dateUpdateChangeDevice;
    }

    public void setDateUpdateChangeDevice(Date dateUpdateChangeDevice) {
        this.dateUpdateChangeDevice = dateUpdateChangeDevice;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }
}
*/