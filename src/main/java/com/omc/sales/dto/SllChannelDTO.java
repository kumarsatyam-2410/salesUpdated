package com.omc.sales.dto;

import java.util.Date;

public class SllChannelDTO {


    private Integer Id;

    private Integer sllId;

    public SllChannelDTO() {
    }

    private String channelNo;


    private int addedBy;


    private Date addedOn;

    private Date updatedOn;



    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getSllId() {
        return sllId;
    }

    public void setSllId(Integer sllId) {
        this.sllId = sllId;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public int getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(int addedBy) {
        this.addedBy = addedBy;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }






}
