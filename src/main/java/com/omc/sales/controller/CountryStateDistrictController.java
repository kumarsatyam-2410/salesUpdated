package com.omc.sales.controller;

import com.omc.sales.dto.*;
import com.omc.sales.entity.*;
import com.omc.sales.exception.BaseException;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.service.CountryStateDistrictService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * The Class CountryStateDistrictController.
 */

@CrossOrigin
@RestController
@RequestMapping("sales")
public class CountryStateDistrictController {

    private static final Logger LOGGER = LogManager.getLogger(CountryStateDistrictController.class);

    @Autowired
    private CountryStateDistrictService countryStateDistrictService;

    @RequestMapping(value = "/getListCountry", method = RequestMethod.GET)
    public ResponseEntity<CountryListResponseDTO> getListCountry() {

        ResponseEntity<CountryListResponseDTO> responseEntity;
        List<Country> list = new ArrayList<>();
        CountryListResponseDTO countryListResponseDTO = new CountryListResponseDTO();
        try {
            LOGGER.info("In CountryStateDistrictController for listAll Country Request");
            list = countryStateDistrictService.getCountryList();
            countryListResponseDTO.setList(list);
            countryListResponseDTO.setStatus(HttpStatus.OK.value());
            responseEntity = new ResponseEntity<>(countryListResponseDTO, HttpStatus.OK);
        } catch (RuntimeException exception) {
            LOGGER.warn("Error occurred while listing country", exception);
            countryListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            countryListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
            countryListResponseDTO.setErrorMessage(exception.getCause().getMessage());
            responseEntity = new ResponseEntity<>(countryListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception exception) {
            LOGGER.warn("Error occurred while listing country", exception);
            countryListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            countryListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
            responseEntity = new ResponseEntity<>(countryListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
            countryListResponseDTO.setErrorMessage(exception.getCause().getMessage());
        }
        return responseEntity;
    }

    @RequestMapping(value = "/getListState", method = RequestMethod.GET)
    public ResponseEntity<StateListResponseDTO> listAllState(@RequestParam(required = false, value="countryId") Integer countryId)

    {
        ResponseEntity<StateListResponseDTO> responseEntity;
        List<State> list = new ArrayList<>();
        StateListResponseDTO stateListResponseDTO= new StateListResponseDTO();
        try {
            LOGGER.info("In CountryStateDistrict for listAll State ");
            list = countryStateDistrictService.listAllState(countryId);
            stateListResponseDTO.setList(list);
            responseEntity = new ResponseEntity<>(stateListResponseDTO, HttpStatus.OK);

        }  catch(RuntimeException exception) {
            LOGGER.warn("Error occurred while listing State", exception);
            responseEntity = new ResponseEntity<>(stateListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
        } catch(Exception exception){
            LOGGER.warn("Error occurred while listing State", exception);
            responseEntity = new ResponseEntity<>(stateListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/getListDistrict", method = RequestMethod.GET)
    public ResponseEntity<DistrictListResponse> listAllDistrict(@RequestParam(required = false, value="stateId") Integer stateId)

    {
        ResponseEntity<DistrictListResponse> responseEntity;
        List<District> list = new ArrayList<>();
        DistrictListResponse districtListResponse= new DistrictListResponse();
        try {
            LOGGER.info("In CountryStateDistrictController for listAll District ");
            list = countryStateDistrictService.listAllDistrict(stateId);
            districtListResponse.setList(list);
            responseEntity = new ResponseEntity<>(districtListResponse, HttpStatus.OK);

        }  catch(RuntimeException exception) {
            LOGGER.warn("Error occurred while listing District", exception);
            responseEntity = new ResponseEntity<>(districtListResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        } catch(Exception exception){
            LOGGER.warn("Error occurred while listing District", exception);
            responseEntity = new ResponseEntity<>(districtListResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}

