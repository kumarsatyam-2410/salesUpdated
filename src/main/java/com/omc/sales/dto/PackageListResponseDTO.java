package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.entity.Package;



public class PackageListResponseDTO extends AbstractResponseDTO{

	private List<Package> list;
	
	public List<Package> getList() {
		return list;
	}
	public void setList(List<Package> list) {
		this.list = list;
	}

}
