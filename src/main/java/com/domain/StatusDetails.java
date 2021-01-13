package com.domain;

import java.util.List;

public class StatusDetails {
	int count; 
	List<CreditCardApplication> applications;
	
	public StatusDetails(List<CreditCardApplication> apps) {
		this.count = apps.size();
		this.applications = apps;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<CreditCardApplication> getApps() {
		return applications;
	}

	public void setApps(List<CreditCardApplication> apps) {
		this.applications = apps;
	} 
	
	
}
