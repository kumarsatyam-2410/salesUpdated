package com.omc.sales.dto;

import com.omc.sales.entity.District;
import com.omc.sales.entity.State;

import java.util.List;

public class DistrictListResponse {


    List<District> list;

    public List<District> getList() {
        return list;
    }

    public void setList(List<District> list) {
        this.list = list;
    }
}
