package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.entity.Customer;



public class CustomerListResponseDTO extends AbstractResponseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Customer> list;
	
	public List<Customer> getList() {
		return list;
	}
	public void setList(List<Customer> list) {
		this.list = list;
	}

}
