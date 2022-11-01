package com.omc.sales.dto;

import com.omc.sales.entity.PollSll;
import com.omc.sales.entity.SllChannel;

import java.util.List;

public class SllChannelListDTO extends AbstractResponseDTO{


    List<SllChannel> list;

    public List<SllChannel> getList() {
        return list;
    }

    public void setList(List<SllChannel> list) {
        this.list = list;
    }
}
