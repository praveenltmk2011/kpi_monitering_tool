package com.snipecrm.kpi.marketing.bindingClasses;

import lombok.Data;

@Data
public class BounceRate {

	private Integer year;
	private String month;
	private Integer totalNoOfVisitors;
	private Integer totalVisitosWithoutInteraction;
	private Integer bounceRate;
	
}
