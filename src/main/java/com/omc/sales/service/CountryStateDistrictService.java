package com.omc.sales.service;

import com.omc.sales.dto.LoginDTO;
import com.omc.sales.dto.StateDTO;
import com.omc.sales.entity.*;
import com.omc.sales.repository.AbhTargetRepository;
import com.omc.sales.repository.CountryRepository;
import com.omc.sales.repository.DistrictRepository;
import com.omc.sales.repository.StateRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
@Service
public class CountryStateDistrictService {


    private static final Logger LOGGER = LogManager.getLogger(CountryStateDistrictService.class);

    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Country> getCountryList() {

        return countryRepository.findAllByOrderByIdDesc();
    }

    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
    public List<State> listAllState(Integer countryId) {

        List<State> subscrptionEntity = null;
        subscrptionEntity = stateRepository.findByCountryId(countryId);

        return subscrptionEntity;

    }
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
    public List<District> listAllDistrict(Integer stateId) {

        List<District> subscrptionEntity1 = null;
        subscrptionEntity1 = districtRepository.findByStateId(stateId);

        return subscrptionEntity1;

    }


}