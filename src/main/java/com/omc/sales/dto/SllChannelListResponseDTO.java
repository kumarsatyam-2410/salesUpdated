package com.omc.sales.dto;

import com.omc.sales.entity.SllChannel;
import com.omc.sales.entity.UserTarget;

import java.util.List;

public class SllChannelListResponseDTO extends AbstractResponseDTO{



    private static final long serialVersionUID = 1L;

    private List<SllChannel> list;

    public List<SllChannel> getList() {
        return list;
    }

    public void setList(List<SllChannel> list) {
        this.list = list;
    }






}
