package com.team71.healerplus.model;

public class DiseaseModel {

    private String diseaseType;
    private String name;
    private String symptoms;
    private String treatment;
    private String medicine;
    private String imgUrl;

    public DiseaseModel(String diseaseType,String name, String symptoms, String treatment,String medicine) {
        this.name = name;
        this.symptoms = symptoms;
        this.treatment = treatment;
        this.diseaseType = diseaseType;
        this.medicine = medicine;
    }

    public DiseaseModel() {

    }

    public String getMedicine() {
        return medicine;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public String getName() {
        return name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
