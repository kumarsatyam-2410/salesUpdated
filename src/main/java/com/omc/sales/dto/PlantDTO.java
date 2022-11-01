package com.omc.sales.dto;

import com.omc.sales.entity.Country;
import com.omc.sales.entity.District;
import com.omc.sales.entity.State;

import java.sql.Timestamp;

public class PlantDTO {


    private Long plantId;

    private Integer omcId;


    private String name;

    private Country country;

    private State state;

    private District district;

    private String type;

    private String remark;

    private Timestamp addedOn;

    private Timestamp updatedOn;

    public Long getPlantId() {
        return plantId;
    }

    public void setPlantId(Long plantId) {
        this.plantId = plantId;
    }

    public Integer getOmcId() {
        return omcId;
    }

    public void setOmcId(Integer omcId) {
        this.omcId = omcId;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public District getDistrict() {
      return district;
    }

  public void setDistrict(District district) {
        this.district = district;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Timestamp addedOn) {
        this.addedOn = addedOn;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    public PlantDTO() {
    }
}
