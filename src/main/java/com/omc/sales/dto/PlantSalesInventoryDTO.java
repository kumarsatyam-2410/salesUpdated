package com.omc.sales.dto;

import java.sql.Timestamp;


public class PlantSalesInventoryDTO {


	private Long userId;
	
    private Long inventoryId;
	
    private int plantId;
	
     private int totalNoPolls;
	
     private int usedNoPolls;
	
     private int freeNoPolls;
	
	private int totalNoSsl;
	
	private int usedNoSsl;
	
	private int freeNoSsl;
	
	private int totalWireMeter;
	
	private int usedWireMeter;
	
	private int freeWireMeter;
	
	private int totalNoBoard;
	
	private int freeNoBoard;
	
	private int usedNoBoard;
	
	private int totalNoRccs;
	
	private int usedNoRccs;

	private int freeNoRccs;
	
	private int totalNoGift;
	
	private int usedNoGift;
	
	private int freeNoGift;
	
	private boolean isActive;
	
	private Timestamp createOn;
	
	private String createBy;
	
	private Timestamp updateOn;
	
	private String updateBy;

	public PlantSalesInventoryDTO() {
	}


	public Long getUserId() {
		return userId;
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public int getPlantId() {
		return plantId;
	}

	public int getTotalNoPolls() {
		return totalNoPolls;
	}

	public int getUsedNoPolls() {
		return usedNoPolls;
	}

	public int getFreeNoPolls() {
		return freeNoPolls;
	}

	public int getTotalNoSsl() {
		return totalNoSsl;
	}

	public int getUsedNoSsl() {
		return usedNoSsl;
	}

	public int getFreeNoSsl() {
		return freeNoSsl;
	}

	public int getTotalWireMeter() {
		return totalWireMeter;
	}

	public int getUsedWireMeter() {
		return usedWireMeter;
	}

	public int getFreeWireMeter() {
		return freeWireMeter;
	}

	public int getTotalNoBoard() {
		return totalNoBoard;
	}

	public int getFreeNoBoard() {
		return freeNoBoard;
	}

	public int getUsedNoBoard() {
		return usedNoBoard;
	}

	public int getTotalNoRccs() {
		return totalNoRccs;
	}

	public int getUsedNoRccs() {
		return usedNoRccs;
	}

	public int getFreeNoRccs() {
		return freeNoRccs;
	}

	public int getTotalNoGift() {
		return totalNoGift;
	}

	public int getUsedNoGift() {
		return usedNoGift;
	}

	public int getFreeNoGift() {
		return freeNoGift;
	}

	public boolean isActive() {
		return isActive;
	}

	public Timestamp getCreateOn() {
		return createOn;
	}

	public String getCreateBy() {
		return createBy;
	}

	public Timestamp getUpdateOn() {
		return updateOn;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public void setTotalNoPolls(int totalNoPolls) {
		this.totalNoPolls = totalNoPolls;
	}

	public void setUsedNoPolls(int usedNoPolls) {
		this.usedNoPolls = usedNoPolls;
	}

	public void setFreeNoPolls(int freeNoPolls) {
		this.freeNoPolls = freeNoPolls;
	}

	public void setTotalNoSsl(int totalNoSsl) {
		this.totalNoSsl = totalNoSsl;
	}

	public void setUsedNoSsl(int usedNoSsl) {
		this.usedNoSsl = usedNoSsl;
	}

	public void setFreeNoSsl(int freeNoSsl) {
		this.freeNoSsl = freeNoSsl;
	}

	public void setTotalWireMeter(int totalWireMeter) {
		this.totalWireMeter = totalWireMeter;
	}

	public void setUsedWireMeter(int usedWireMeter) {
		this.usedWireMeter = usedWireMeter;
	}

	public void setFreeWireMeter(int freeWireMeter) {
		this.freeWireMeter = freeWireMeter;
	}

	public void setTotalNoBoard(int totalNoBoard) {
		this.totalNoBoard = totalNoBoard;
	}

	public void setFreeNoBoard(int freeNoBoard) {
		this.freeNoBoard = freeNoBoard;
	}

	public void setUsedNoBoard(int usedNoBoard) {
		this.usedNoBoard = usedNoBoard;
	}

	public void setTotalNoRccs(int totalNoRccs) {
		this.totalNoRccs = totalNoRccs;
	}

	public void setUsedNoRccs(int usedNoRccs) {
		this.usedNoRccs = usedNoRccs;
	}

	public void setFreeNoRccs(int freeNoRccs) {
		this.freeNoRccs = freeNoRccs;
	}

	public void setTotalNoGift(int totalNoGift) {
		this.totalNoGift = totalNoGift;
	}

	public void setUsedNoGift(int usedNoGift) {
		this.usedNoGift = usedNoGift;
	}

	public void setFreeNoGift(int freeNoGift) {
		this.freeNoGift = freeNoGift;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setCreateOn(Timestamp createOn) {
		this.createOn = createOn;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public void setUpdateOn(Timestamp updateOn) {
		this.updateOn = updateOn;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Override
	public String toString() {
		return "PlantSalesInventoryDTO [userId=" + userId + ", inventoryId=" + inventoryId + ", plantId=" + plantId
				+ ", totalNoPolls=" + totalNoPolls + ", usedNoPolls=" + usedNoPolls + ", freeNoPolls=" + freeNoPolls
				+ ", totalNoSsl=" + totalNoSsl + ", usedNoSsl=" + usedNoSsl + ", freeNoSsl=" + freeNoSsl
				+ ", totalWireMeter=" + totalWireMeter + ", usedWireMeter=" + usedWireMeter + ", freeWireMeter="
				+ freeWireMeter + ", totalNoBoard=" + totalNoBoard + ", freeNoBoard=" + freeNoBoard + ", usedNoBoard="
				+ usedNoBoard + ", totalNoRccs=" + totalNoRccs + ", usedNoRccs=" + usedNoRccs + ", freeNoRccs="
				+ freeNoRccs + ", totalNoGift=" + totalNoGift + ", usedNoGift=" + usedNoGift + ", freeNoGift="
				+ freeNoGift + ", isActive=" + isActive + ", createOn=" + createOn + ", createBy=" + createBy
				+ ", updateOn=" + updateOn + ", updateBy=" + updateBy + "]";
	}
	
	
}
