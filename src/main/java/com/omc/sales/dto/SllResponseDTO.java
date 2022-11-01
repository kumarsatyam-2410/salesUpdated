package com.omc.sales.dto;

import com.omc.sales.entity.PlantPoll;
import com.omc.sales.entity.PollSll;

import java.util.List;

public class SllResponseDTO  extends AbstractResponseDTO{


    private List<PollSll> list;

    public List<PollSll> getList() {
        return list;
    }

    public void setList(List<PollSll> list) {
        this.list = list;
    }
}
