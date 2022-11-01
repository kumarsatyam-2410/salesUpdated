package com.omc.sales.dto;

import com.omc.sales.entity.Country;
import com.omc.sales.entity.State;

import java.util.List;

public class CountryListResponseDTO extends AbstractResponseDTO{



    List<Country> list;







    public List<Country> getList() {
        return list;
    }

    public void setList(List<Country> list) {
        this.list = list;
    }
}
