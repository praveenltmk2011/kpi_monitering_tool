package com.snipecrm.kpi.sales.bindingClasses;

import lombok.Data;

@Data
public class OpportunitiesToWinRatio {

	private Integer year;
	private String month;
	private Integer noOfOpportunitesWon;
	private Integer totalNoOfOpportunities;
	private Integer opportunitiesToWinRatio;
	
}
