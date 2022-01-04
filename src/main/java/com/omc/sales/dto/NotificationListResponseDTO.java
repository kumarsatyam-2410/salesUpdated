package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.entity.Notification;



public class NotificationListResponseDTO extends AbstractResponseDTO{

	private List<Notification> list;
	
	public List<Notification> getList() {
		return list;
	}
	public void setList(List<Notification> list) {
		this.list = list;
	}

}
