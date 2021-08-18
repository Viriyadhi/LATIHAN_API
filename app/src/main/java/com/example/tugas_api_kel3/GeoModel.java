package com.example.tugas_api_kel3;

public class GeoModel {
    private String geoName, geoCapital, geoRegion, geoFlag, geoPopulation;

    public GeoModel(String geoName, String geoCapital, String geoRegion, String geoPopulation, String geoFlag) {
        this.geoName = geoName;
        this.geoCapital = geoCapital;
        this.geoRegion = geoRegion;
        this.geoPopulation = geoPopulation;
        this.geoFlag = geoFlag;
    }

    public String getGeoName() {
        return geoName;
    }

    public void setGeoName(String geoName) {
        this.geoName = geoName;
    }

    public String getGeoCapital() {
        return geoCapital;
    }

    public void setGeoCapital(String geoCapital) {
        this.geoCapital = geoCapital;
    }

    public String getGeoRegion() {
        return geoRegion;
    }

    public void setGeoRegion(String geoRegion) {
        this.geoRegion = geoRegion;
    }

    public String getGeoPopulation() {
        return geoPopulation;
    }

    public void setGeoPopulation(String geoPopulation) {
        this.geoPopulation = geoPopulation;
    }

    public String getGeoFlag() {
        return geoFlag;
    }

    public void setGeoFlag(String geoFlag) {
        this.geoFlag = geoFlag;
    }
}

