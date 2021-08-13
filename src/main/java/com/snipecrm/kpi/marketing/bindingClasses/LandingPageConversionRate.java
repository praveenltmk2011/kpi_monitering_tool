package com.snipecrm.kpi.marketing.bindingClasses;

import lombok.Data;

@Data
public class LandingPageConversionRate {

	private Integer year;
	private String month;
	private Integer totalNoOfVisitors;
	private Integer totalNoOfConversions;
	private Integer landingPageConversionRate;
	
}
