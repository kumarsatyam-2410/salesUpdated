package com.omc.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.omc.sales.entity.Package;



/**
 * The Interface CustomerRepository.
 */
@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {
	
public List<Package> findByPackageTypeAndBillingTypeAndClosedPackage(String packageType,String billingType,int closedPackage);

	public Package findByPackageName(String packageName);
	
}
