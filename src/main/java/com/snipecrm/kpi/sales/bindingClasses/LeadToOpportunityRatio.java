package com.snipecrm.kpi.sales.bindingClasses;

import lombok.Data;

@Data
public class LeadToOpportunityRatio {

	private Integer year;
	private String month;
	private Integer leadConv2Opportunities;
	private Integer totalNoOfLeads;
	private Integer leadsToOpportunityRatio;
	private Integer LeadToOpportunity;
	
}
