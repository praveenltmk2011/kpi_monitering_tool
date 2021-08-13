package com.snipecrm.kpi.sales.bindingClasses;

import lombok.Data;

@Data
public class CustomerLifetimeValue {

	private Integer year;
	private String month;
	private Float avgPurchaseValue;
	private Float avgPurchaseFreqRate;
	private Float avgCustomerLifespan;
	private Integer customerLifetimeValue;
	
}
