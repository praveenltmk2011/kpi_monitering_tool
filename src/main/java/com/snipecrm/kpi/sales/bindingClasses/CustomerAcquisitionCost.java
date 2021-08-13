package com.snipecrm.kpi.sales.bindingClasses;

import lombok.Data;

@Data
public class CustomerAcquisitionCost {

	private Integer year;
	private String month;
	private Float costOfSales;
	private Float costOfMarketing;
	private Integer newCustomersAcquired;
	private Float customerAcquisitionCost;
	//private Integer avgCustomerAcquisitionCost;
	
}
