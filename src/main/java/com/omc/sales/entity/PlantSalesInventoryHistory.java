package com.omc.sales.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="plant_sales_inventory_history")
public class PlantSalesInventoryHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="inventory_id")
	private Long inventoryId;
	
	@Column(name="plant_id")
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

	public PlantSalesInventoryHistory() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public int getTotalNoPolls() {
		return totalNoPolls;
	}

	public void setTotalNoPolls(int totalNoPolls) {
		this.totalNoPolls = totalNoPolls;
	}

	public int getUsedNoPolls() {
		return usedNoPolls;
	}

	public void setUsedNoPolls(int usedNoPolls) {
		this.usedNoPolls = usedNoPolls;
	}

	public int getFreeNoPolls() {
		return freeNoPolls;
	}

	public void setFreeNoPolls(int freeNoPolls) {
		this.freeNoPolls = freeNoPolls;
	}

	public int getTotalNoSll() {
		return totalNoSll;
	}

	public void setTotalNoSll(int totalNoSll) {
		this.totalNoSll = totalNoSll;
	}

	public int getUsedNoSll() {
		return usedNoSll;
	}

	public void setUsedNoSll(int usedNoSll) {
		this.usedNoSll = usedNoSll;
	}

	public int getFreeNoSll() {
		return freeNoSll;
	}

	public void setFreeNoSll(int freeNoSll) {
		this.freeNoSll = freeNoSll;
	}

	public int getTotalWireMeter() {
		return totalWireMeter;
	}

	public void setTotalWireMeter(int totalWireMeter) {
		this.totalWireMeter = totalWireMeter;
	}

	public int getUsedWireMeter() {
		return usedWireMeter;
	}

	public void setUsedWireMeter(int usedWireMeter) {
		this.usedWireMeter = usedWireMeter;
	}

	public int getFreeWireMeter() {
		return freeWireMeter;
	}

	public void setFreeWireMeter(int freeWireMeter) {
		this.freeWireMeter = freeWireMeter;
	}

	public int getTotalNoBoard() {
		return totalNoBoard;
	}

	public void setTotalNoBoard(int totalNoBoard) {
		this.totalNoBoard = totalNoBoard;
	}

	public int getFreeNoBoard() {
		return freeNoBoard;
	}

	public void setFreeNoBoard(int freeNoBoard) {
		this.freeNoBoard = freeNoBoard;
	}

	public int getUsedNoBoard() {
		return usedNoBoard;
	}

	public void setUsedNoBoard(int usedNoBoard) {
		this.usedNoBoard = usedNoBoard;
	}

	public int getTotalNoRccs() {
		return totalNoRccs;
	}

	public void setTotalNoRccs(int totalNoRccs) {
		this.totalNoRccs = totalNoRccs;
	}

	public int getUsedNoRccs() {
		return usedNoRccs;
	}

	public void setUsedNoRccs(int usedNoRccs) {
		this.usedNoRccs = usedNoRccs;
	}

	public int getFreeNoRccs() {
		return freeNoRccs;
	}

	public void setFreeNoRccs(int freeNoRccs) {
		this.freeNoRccs = freeNoRccs;
	}

	public int getTotalNoGift() {
		return totalNoGift;
	}

	public void setTotalNoGift(int totalNoGift) {
		this.totalNoGift = totalNoGift;
	}

	public int getUsedNoGift() {
		return usedNoGift;
	}

	public void setUsedNoGift(int usedNoGift) {
		this.usedNoGift = usedNoGift;
	}

	public int getFreeNoGift() {
		return freeNoGift;
	}

	public void setFreeNoGift(int freeNoGift) {
		this.freeNoGift = freeNoGift;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Timestamp getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Timestamp createOn) {
		this.createOn = createOn;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
	

}
