package com.omc.sales.dto;

import com.omc.sales.entity.Plant;

import java.sql.Timestamp;

public class PlantPollDTO {

    private Long ppId;

    private Long pollNumber;


    private Plant plant;

    private Timestamp addedOn;

    private Timestamp updatedOn;

    public PlantPollDTO() {
    }

    public Long getPpId() {
        return ppId;
    }

    public void setPpId(Long ppId) {
        this.ppId = ppId;
    }

    public Long getPollNumber() {
        return pollNumber;
    }

    public void setPollNumber(Long pollNumber) {
        this.pollNumber = pollNumber;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
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
}
