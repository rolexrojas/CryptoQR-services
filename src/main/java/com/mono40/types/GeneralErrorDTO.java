package com.mono40.types;

public class GeneralErrorDTO {
    private SysError error;

    public GeneralErrorDTO(SysError error){
        this.error = error;
    }

    @Override
    public String toString() {
        return "{" +
                "\"error\":" + error +
                '}';
    }
}
