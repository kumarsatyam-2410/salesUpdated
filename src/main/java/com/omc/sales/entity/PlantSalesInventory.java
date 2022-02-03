package com.omc.sales.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="plant_sales_inventory")
public class PlantSalesInventory {
	
	@Column(name="user_id")
	private Long userId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="inventory_id")
	private Long inventoryId;
	
	@Column(name="plantid")
	private int plantId;
	
	@Column(name="total_no_polls")
	private int totalNoPolls;
	
	@Column(name="used_no_polls")
	private int usedNoPolls;
	
	@Column(name="free_no_polls")
	private int freeNoPolls;
	
	@Column(name="total_no_sll")
	private int totalNoSll;
	
	@Column(name="used_no_sll")
	private int usedNoSll;
	
	@Column(name="free_no_sll")
	private int freeNoSll;
	
	@Column(name="total_wire_meter")
	private int totalWireMeter;
	
	@Column(name="used_wire_meter")
	private int usedWireMeter;
	
	@Column(name="free_wire_meter")
	private int freeWireMeter;
	
	@Column(name="total_no_board")
	private int totalNoBoard;
	
	@Column(name="free_no_board")
	private int freeNoBoard;
	
	@Column(name="used_no_board")
	private int usedNoBoard;
	
	@Column(name="total_no_rccs")
	private int totalNoRccs;
	
	@Column(name="used_no_rccs")
	private int usedNoRccs;

	@Column(name="free_no_rccs")
	private int freeNoRccs;
	
	@Column(name="total_no_gift")
	private int totalNoGift;
	
	@Column(name="used_no_gift")
	private int usedNoGift;
	
	@Column(name="free_no_gift")
	private int freeNoGift;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="created_on")
	private Timestamp createOn;
	
	@Column(name="created_by")
	private String createBy;
	
	@Column(name="updated_on")
	private Timestamp updatedOn;
	
	@Column(name="updated_by")
	private String updatedBy;

	public PlantSalesInventory() {
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

	public int getTotalNoSll() {
		return totalNoSll;
	}

	public int getUsedNoSll() {
		return usedNoSll;
	}

	public int getFreeNoSll() {
		return freeNoSll;
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

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
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

	public void setTotalNoSll(int totalNoSll) {
		this.totalNoSll = totalNoSll;
	}

	public void setUsedNoSll(int usedNoSll) {
		this.usedNoSll = usedNoSll;
	}

	public void setFreeNoSll(int freeNoSll) {
		this.freeNoSll = freeNoSll;
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

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "PlantSalesInventory [userId=" + userId + ", inventoryId=" + inventoryId + ", plantId=" + plantId
				+ ", totalNoPolls=" + totalNoPolls + ", usedNoPolls=" + usedNoPolls + ", freeNoPolls=" + freeNoPolls
				+ ", totalNoSll=" + totalNoSll + ", usedNoSll=" + usedNoSll + ", freeNoSll=" + freeNoSll
				+ ", totalWireMeter=" + totalWireMeter + ", usedWireMeter=" + usedWireMeter + ", freeWireMeter="
				+ freeWireMeter + ", totalNoBoard=" + totalNoBoard + ", freeNoBoard=" + freeNoBoard + ", usedNoBoard="
				+ usedNoBoard + ", totalNoRccs=" + totalNoRccs + ", usedNoRccs=" + usedNoRccs + ", freeNoRccs="
				+ freeNoRccs + ", totalNoGift=" + totalNoGift + ", usedNoGift=" + usedNoGift + ", freeNoGift="
				+ freeNoGift + ", isActive=" + isActive + ", createOn=" + createOn + ", createBy=" + createBy
				+ ", updatedOn=" + updatedOn + ", updatedBy=" + updatedBy + "]";
	}

	
	
}
