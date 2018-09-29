package com.janas.rewardssimulator.business.sale.entity;

import java.io.Serializable;
import java.util.Date;

import com.janas.rewardssimulator.business.sale.boundary.ContractAction;
import com.janas.rewardssimulator.business.sale.boundary.ContractType;

public class SalesRecord implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	
	private long partnerId;
	private long contractId;
	private ContractType contractType;
	private Date sellDate;
	private ContractAction action;
	
	public SalesRecord() {
		
	}
	
	public SalesRecord(long partnerId, long contractId, ContractType contractType, Date sellDate, ContractAction action) {
		super();
		this.partnerId = partnerId;
		this.contractId = contractId;
		this.contractType = contractType;
		this.sellDate = sellDate;
		this.action = action;
	}



	public long getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(long partnerId) {
		this.partnerId = partnerId;
	}
	public long getContractId() {
		return contractId;
	}
	public void setContractId(long contractId) {
		this.contractId = contractId;
	}
	public ContractType getContractType() {
		return contractType;
	}
	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}
	public Date getSellDate() {
		return sellDate;
	}
	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}
	public ContractAction getAction() {
		return action;
	}
	public void setAction(ContractAction action) {
		this.action = action;
	}
	
	
	


}
