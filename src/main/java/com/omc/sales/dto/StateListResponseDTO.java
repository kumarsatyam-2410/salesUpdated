package com.omc.sales.dto;

import com.omc.sales.entity.State;

import java.util.List;

public class StateListResponseDTO extends AbstractResponseDTO{


    List<State> list;

    public List<State> getList() {
        return list;
    }

    public void setList(List<State> list) {
        this.list = list;
    }
}
