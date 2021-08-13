package com.snipecrm.kpi.sales.bindingClasses;

import lombok.Data;

@Data
public class AverageRevenuePerUnit {

	private Integer year;
	private String month;
	private Float totalSalesRevenue;
	private Integer noOfUnitsSold;
	private Integer avgRevenuePerUnit;
	
}
