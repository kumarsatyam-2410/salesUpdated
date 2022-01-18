package com.omc.sales.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.omc.sales.dto.DashboardDTO;
import com.omc.sales.entity.CustomerAcquisition;
import com.omc.sales.entity.PlantUsers;
import com.omc.sales.entity.User;
import com.omc.sales.repository.CustomerAcquisitionRepository;
import com.omc.sales.repository.UsersRepository;

@Service
@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
public class DashBoardService {


	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private CustomerAcquisitionRepository customerAcquisitionRepository;

	private static BigDecimal INITILISE_BIGDECIMAL = new BigDecimal(0);


	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public DashboardDTO prepareDashBoard(Long userId) {

		// userId -> plantId(1,2,3) -> solarTop(1,2,3)
		DashboardDTO dashBoardDTO = new DashboardDTO();
		
		DashboardDTO.CustomerData customerData = dashBoardDTO.new CustomerData();
		DashboardDTO.RevenueData revenueData =  dashBoardDTO.new RevenueData();
		DashboardDTO.ActivationData activationData =  dashBoardDTO.new ActivationData();
		DashboardDTO.BusinessInventory businessData = dashBoardDTO.new BusinessInventory();
		
		User user = userRepository.findById(userId).get();
		dashBoardDTO.setUserId(userId.toString());
		dashBoardDTO.setUserEmail(user.getEmail());
		List<CustomerAcquisition> list = customerAcquisitionRepository.findByIsActiveAndAcquisitionStatusAndSalesExecutiveId(true, "Closed", "11");
			
			//List<CustomerAcquisition> list = customerAcquisitionRepository.findByAcquisition_status(true, "Closed");
			customerData.setTotalCustomerAcquired(""+list.size());
			
			customerData.setTotalCustomerAcquiredCurrentMonth(""+list.size());
			customerData.setTargetCustomerAcquiredCurrentMonth(""+list.size());
			customerData.setTargetCustomerAcquired(""+list.size());
			dashBoardDTO.setCustomerData(customerData);
		//}

		

		return dashBoardDTO;
	}




}
