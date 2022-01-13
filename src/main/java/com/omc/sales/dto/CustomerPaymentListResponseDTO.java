package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.entity.Customer;
import com.omc.sales.entity.CustomerPaymentDetails;



public class CustomerPaymentListResponseDTO extends AbstractResponseDTO{

	private List<CustomerPaymentDetails> list;
	
	public List<CustomerPaymentDetails> getList() {
		return list;
	}
	public void setList(List<CustomerPaymentDetails> list) {
		this.list = list;
	}

}
