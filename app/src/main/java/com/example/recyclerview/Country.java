package com.example.recyclerview;

public class Country {
    private String cName;
    private String cFlag;

    public Country(String cName, String cFlag) {
        this.cName = cName;
        this.cFlag = cFlag;
    }

    public Country() {
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcFlag() {
        return cFlag;
    }

    public void setcFlag(String cFlag) {
        this.cFlag = cFlag;
    }
}
