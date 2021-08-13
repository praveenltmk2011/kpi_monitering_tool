package com.snipecrm.kpi.sales.bindingClasses;

import lombok.Data;

@Data
public class LeadConversionRatio {

	private Integer year;
	private String month;
	private Integer leadsConvertedToOpportunites;
	private Integer totalNoOfLeads;
	private Integer leadConversionRatio;
	
}
