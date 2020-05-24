package com.mono40.domain;



import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by yarielinfante on 2/21/17.
 */

@Entity
public class BankBinImage {

    @Id
    private int bin;
    private String bankId;
    private String imageName;

    public int getBin() {
        return bin;
    }

    public void setBin(int bin) {
        this.bin = bin;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
