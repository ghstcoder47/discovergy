package com.janas.rewardssimulator.business.partner.entity;

import java.io.Serializable;

import com.janas.rewardssimulator.business.sale.boundary.PartnerLevel;

public class Partner implements Serializable {	
	
	private static final long serialVersionUID = 1L;

	
	long partnerId;	
	long parentPartnerId;	
	PartnerLevel level;
	
	public Partner() {
		
	}	
	
	public Partner(long partnerId, PartnerLevel level) {
		super();
		this.partnerId = partnerId;
		this.level = level;
	}
		
	public Partner(long partnerId, long parentPartnerId, PartnerLevel level) {
		super();
		this.partnerId = partnerId;
		this.parentPartnerId = parentPartnerId;
		this.level = level;
	}

	public long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(long partnerId) {
		this.partnerId = partnerId;
	}

	public long getParentPartnerId() {
		return parentPartnerId;
	}

	public void setParentPartnerId(long parentPartnerId) {
		this.parentPartnerId = parentPartnerId;
	}

	public PartnerLevel getLevel() {
		return level;
	}

	public void setLevel(PartnerLevel level) {
		this.level = level;
	}

	

}
