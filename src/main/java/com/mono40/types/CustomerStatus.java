package com.mono40.types;


public class CustomerStatus {

    public interface Status {
        int GCS_NO_AFFILIATED = 1;
        int GCS_AFFILIATED_NON_PROFILE = 2;
        int GCS_AFFILIATED_PROFILE = 3;
    }

    private int status;

    public CustomerStatus() {
    }

    public CustomerStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
