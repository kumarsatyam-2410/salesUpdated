package com.omc.sales.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.omc.sales.dto.PackageDTO;
import com.omc.sales.entity.Package;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.exception.SSNSQLException;
import com.omc.sales.repository.PackageRepository;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@Service
public class PackageService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(PackageService.class);

	/** The package repository. */
	@Autowired
	private PackageRepository packageRepository;


	/**
	 * Creates the package.
	 *
	 * @param packageDTO  the package DTO
	 * @param callInfo the call info
	 * @return the string
	 * @throws SSNSQLException 
	 * @throws Throwable 
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public Long createPackage(PackageDTO packageDTO) throws SSNSQLException{

		LOGGER.info("Request Received for createPackage with parameters:"+ "packageName: " + packageDTO.getPackageName());

		// validate unique package


		
		Package packageEntity = new Package();
		packageEntity.setActive(packageDTO.isActive());
		packageEntity.setPackageName(packageDTO.getPackageName());
		packageEntity.setPackageDescription(packageDTO.getPackageDescription());
		packageEntity.setPackageType(packageDTO.getPackageType());
		packageEntity.setAmount(packageDTO.getAmount());
		packageEntity.setTotalLoad(packageDTO.getTotalLoad());
		packageEntity.setMaxLoadPerDay(packageDTO.getMaxLoadPerDay());
		packageEntity.setSuplyHours(packageDTO.getSuplyHours());
		//packageEntity.setAddedOn(packageDTO.getAddedOn());
		packageEntity.setUpdatedOn(packageDTO.getUpdatedOn());
		packageEntity.setCreated_by(packageDTO.getCreated_by());
		packageEntity.setUpdated_by(packageDTO.getUpdated_by());
		packageEntity.setCustomerType(packageDTO.getCustomerType());
		packageEntity.setUnit_price(packageDTO.getUnit_price());
		packageEntity.setBillingType(packageDTO.getBillingType());
		packageEntity.setOTI(packageDTO.getOTI());
		packageEntity.setRemarks(packageDTO.getRemarks());
		packageEntity.setValidityDays(packageDTO.getValidityDays());
		packageEntity.setMinimumPackageMonthly(packageDTO.getMinimumPackageMonthly());
		packageEntity.setStartTiming(packageDTO.getStartTiming());
		packageEntity.setEndTiming(packageDTO.getEndTiming());
		packageEntity.setClosedPackage(packageDTO.getClosedPackage());
		packageEntity.setChurn(packageDTO.getChurn());
		packageEntity.setGrace(packageDTO.getGrace());
		packageRepository.save(packageEntity);

		LOGGER.info("Out createPackage service with return Value packageId:"+packageEntity.getId()); 
		return packageEntity.getId();
	}


	/**
	 * List all packages.
	 * @param closedPackage 
	 * @param billingType 
	 * @param packageType 
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<Package> listAllPackages(String packageType, String billingType, int closedPackage) {
		LOGGER.info("In listAllPackages  Service");
		List<Package> packages = new ArrayList<>();
		packages=packageRepository.findByPackageTypeAndBillingTypeAndClosedPackage(packageType,billingType,closedPackage);
		return packages;
	}


	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public Long updatePackage(PackageDTO packageDTO) {
		LOGGER.info("In updatePackage  Service");
		Package packageEntity = packageRepository.findByPackageName(packageDTO.getPackageName());
		
		packageEntity.setPackageDescription(packageDTO.getPackageDescription());
		packageEntity.setPackageType(packageDTO.getPackageType());
		packageEntity.setAmount(packageDTO.getAmount());
		packageEntity.setTotalLoad(packageDTO.getTotalLoad());
		packageEntity.setMaxLoadPerDay(packageDTO.getMaxLoadPerDay());
		packageEntity.setSuplyHours(packageDTO.getSuplyHours());
		//packageEntity.setAddedOn(packageDTO.getAddedOn());
		packageEntity.setUpdatedOn(packageDTO.getUpdatedOn());
		//packageEntity.setCreated_by(packageDTO.getCreated_by());
		packageEntity.setUpdated_by(packageDTO.getUpdated_by());
		packageEntity.setActive(packageDTO.isActive());
		packageEntity.setCustomerType(packageDTO.getCustomerType());
		packageEntity.setUnit_price(packageDTO.getUnit_price());
		packageEntity.setBillingType(packageDTO.getBillingType());
		packageEntity.setOTI(packageDTO.getOTI());
		packageEntity.setRemarks(packageDTO.getRemarks());
		packageEntity.setValidityDays(packageDTO.getValidityDays());
		packageEntity.setMinimumPackageMonthly(packageDTO.getMinimumPackageMonthly());
		packageEntity.setStartTiming(packageDTO.getStartTiming());
		packageEntity.setEndTiming(packageDTO.getEndTiming());
		packageEntity.setClosedPackage(packageDTO.getClosedPackage());
		packageEntity.setChurn(packageDTO.getChurn());
		packageEntity.setGrace(packageDTO.getGrace());
		
		LOGGER.info("Out Package Updated for "+packageEntity.getId()); 
		return packageEntity.getId();
	}

    //get only one record of package
	public List<Package> listAllPackage(Long id) {
		List list = new ArrayList<>();
		Optional<Package> p=packageRepository.findById(id);
		list.add(p);
		return list;
	}


	public List<Package> listAllPackages() {
		
		return packageRepository.findAllByOrderByIdDesc();
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public Long deletePackage(Long id) {
		LOGGER.info("In deletePackage  Service" + packageRepository.deleteByid(id));
		Long aid = packageRepository.deleteByid(id);
		return id;


	}


}
