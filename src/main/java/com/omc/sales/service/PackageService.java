package com.omc.sales.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
		Package existingPackageEntity = packageRepository.findByPackageName(packageDTO.getPackageName());
		if(existingPackageEntity != null){
			throw new SSNSQLException("Not Unique Package", ErrorCodes.NOT_UNIQUE_PACKAGE);
		}
		
		Package packageEntity = new Package();
		packageEntity.setActive(packageDTO.isActive());
		packageEntity.setPackageName(packageDTO.getPackageName());
		packageEntity.setPackageDescription(packageDTO.getPackageDescription());
		packageEntity.setPackageType(packageDTO.getPackageType());
		packageEntity.setAmount(BigDecimal.valueOf(Double.valueOf(packageDTO.getAmount())));
		packageEntity.setMaxLoadPerDay(BigDecimal.valueOf(Double.valueOf(packageDTO.getMaxLoadPerDay())));
		packageEntity.setTotalLoad(BigDecimal.valueOf(Double.valueOf(packageDTO.getTotalLoad())));
		packageEntity.setSuplyHours(packageDTO.getSuplyHours());
		//packageEntity.setAddedOn(packageDTO.getAddedOn());
		packageEntity.setUpdatedOn(packageDTO.getUpdatedOn());
		packageEntity.setCreated_by(packageDTO.getCreated_by());
		packageEntity.setUpdated_by(packageDTO.getUpdated_by());
		packageRepository.save(packageEntity);

		LOGGER.info("Out createPackage service with return Value packageId:"+packageEntity.getId()); 
		return packageEntity.getId();
	}


	/**
	 * List all packages.
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<Package> listAllPackages() {
		LOGGER.info("In listAllPackages  Service");
		List<Package> packages = new ArrayList<>();
		packageRepository.findAll().forEach(packages::add);
		return packages;
	}


	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public Long updatePackage(PackageDTO packageDTO) {
		LOGGER.info("In updatePackage  Service");
		Package packageEntity = packageRepository.findByPackageName(packageDTO.getPackageName());
		packageEntity.setPackageDescription(packageDTO.getPackageDescription());
		packageEntity.setPackageType(packageDTO.getPackageType());
		packageEntity.setAmount(BigDecimal.valueOf(Double.valueOf(packageDTO.getAmount())));
		packageEntity.setMaxLoadPerDay(BigDecimal.valueOf(Double.valueOf(packageDTO.getMaxLoadPerDay())));
		packageEntity.setTotalLoad(BigDecimal.valueOf(Double.valueOf(packageDTO.getTotalLoad())));
		packageEntity.setSuplyHours(packageDTO.getSuplyHours());
		//packageEntity.setAddedOn(packageDTO.getAddedOn());
		packageEntity.setUpdatedOn(packageDTO.getUpdatedOn());
		//packageEntity.setCreated_by(packageDTO.getCreated_by());
		packageEntity.setUpdated_by(packageDTO.getUpdated_by());
		packageEntity.setActive(packageDTO.isActive());
		
		LOGGER.info("Out Package Updated for "+packageEntity.getId()); 
		return packageEntity.getId();
	}


}
