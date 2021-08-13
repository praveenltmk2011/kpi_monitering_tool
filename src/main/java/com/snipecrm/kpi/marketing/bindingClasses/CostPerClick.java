package com.snipecrm.kpi.marketing.bindingClasses;

import lombok.Data;

@Data
public class CostPerClick {

	private Integer year;
	private String month;
	private Float totalAmtSpent;
	private Integer totalMeasurableClicks;
	private Float costPerClick;
	
}
