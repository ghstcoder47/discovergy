package com.janas.rewardssimulator.business.partners.entity;

import java.io.Serializable;

public class Partner implements Serializable {	
	
	private static final long serialVersionUID = 1L;

	
	long partnerId;	
	long parentPartnerId;
	
	public Partner() {
		
	}	
	
	public Partner(long partnerId) {
		super();
		this.partnerId = partnerId;
	}
		
	public Partner(long partnerId, long parentPartnerId) {
		super();
		this.partnerId = partnerId;
		this.parentPartnerId = parentPartnerId;
	}

	public long getParentPartnerId() {
		return parentPartnerId;
	}

	public void setParentPartnerId(long parentPartnerId) {
		this.parentPartnerId = parentPartnerId;
	}

	public long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(long partnerId) {
		this.partnerId = partnerId;
	}

}
