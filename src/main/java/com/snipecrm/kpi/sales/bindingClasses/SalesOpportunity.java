package com.snipecrm.kpi.sales.bindingClasses;

import lombok.Data;

@Data
public class SalesOpportunity {

	private Integer year;
	private String month;
	private Integer totalSalesActivitiesLogged;
	private Integer totalNoOpportunities;
	private Integer noOfSalesOpportunity;
	
}
