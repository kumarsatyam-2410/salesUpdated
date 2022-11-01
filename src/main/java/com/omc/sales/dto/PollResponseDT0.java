package com.omc.sales.dto;

import com.omc.sales.entity.PlantPoll;

import java.util.List;

public class PollResponseDT0 extends AbstractResponseDTO {


    private List<PlantPoll> list;

    public List<PlantPoll> getList() {
        return list;
    }

    public void setList(List<PlantPoll> list) {
        this.list = list;
    }
}
