package com.omc.sales.repository;

import com.omc.sales.entity.SllChannel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SllChannelRepository extends JpaRepository<SllChannel,Long> {


    public List<SllChannel> findAllBySllId (Integer sllId);
}
