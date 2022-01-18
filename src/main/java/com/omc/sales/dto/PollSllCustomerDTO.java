package com.omc.sales.dto;

import java.sql.Timestamp;
import java.util.List;

import com.omc.sales.entity.PlantPoll;
import com.omc.sales.entity.PollSll;
import com.omc.sales.entity.SllCustomer;

/**
 * The Class CustomerDTO.
 */
public class PollSllCustomerDTO {

	/**
	 * Instantiates a new user DTO.
	 */
	public PollSllCustomerDTO() {

	}

	private String planiId;
	
	private List<PlantPoll> plantPoll;

	private List<PollSll> pollSLL;

	private List<SllCustomer> sllCustomer;

	public List<PlantPoll> getPlantPoll() {
		return plantPoll;
	}

	public List<PollSll> getPollSLL() {
		return pollSLL;
	}

	public List<SllCustomer> getSllCustomer() {
		return sllCustomer;
	}

	public void setPlantPoll(List<PlantPoll> plantPoll) {
		this.plantPoll = plantPoll;
	}

	public void setPollSLL(List<PollSll> pollSLL) {
		this.pollSLL = pollSLL;
	}

	public void setSllCustomer(List<SllCustomer> sllCustomer) {
		this.sllCustomer = sllCustomer;
	}

	public String getPlaniId() {
		return planiId;
	}

	public void setPlaniId(String planiId) {
		this.planiId = planiId;
	}

	
	





	

}