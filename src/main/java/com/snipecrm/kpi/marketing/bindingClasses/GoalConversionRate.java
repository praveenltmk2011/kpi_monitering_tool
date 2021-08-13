package com.snipecrm.kpi.marketing.bindingClasses;

import lombok.Data;

@Data
public class GoalConversionRate {

	private Integer year;
	private String month;
	private Integer totalNoOfConversions;
	private Integer totalNoOfVisitors;
	private Float goalConversionRate;
	
}
