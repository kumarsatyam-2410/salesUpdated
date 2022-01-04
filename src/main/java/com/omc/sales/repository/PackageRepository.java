package com.omc.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.omc.sales.entity.Package;



/**
 * The Interface CustomerRepository.
 */
@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {

	public Package findByPackageName(String packageName);
	
}
