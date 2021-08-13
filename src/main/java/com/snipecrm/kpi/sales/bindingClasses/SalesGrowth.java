package com.snipecrm.kpi.sales.bindingClasses;

import lombok.Data;

@Data
public class SalesGrowth {

	private Integer year;
	private String month;
	private Integer currentPeriodSales;
	private Integer priorPeriodSales;
	private Integer salesGrowth;
	
}
