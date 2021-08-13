package com.snipecrm.kpi.sales.bindingClasses;

import lombok.Data;

@Data
public class SalesTarget {

	private Integer year;
	private String month;
	private Integer newCustomersAcquired;
	private Float salesRevenue;
	private Integer currentPeriodSales;
	private Integer targetSet;
	private Integer salesTarget;
	
}
