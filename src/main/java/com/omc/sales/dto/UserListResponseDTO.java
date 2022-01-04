package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.entity.User;

public class UserListResponseDTO extends AbstractResponseDTO{

	private List<User> list;
	
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}

}
