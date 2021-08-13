package com.snipecrm.kpi.marketing.bindingClasses;

import lombok.Data;

@Data
public class CostPerAcquisition {

	private Integer year;
	private String month;
	private Integer totalNoOfVisitors;
	private Float totalAmtSpent;
	private Integer totalNoOfConversions;
	private Float costPerAcquisition;
}
