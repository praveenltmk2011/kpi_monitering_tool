package com.snipecrm.kpi.marketing.bindingClasses;

import lombok.Data;

@Data
public class CostPerLead {

	private Integer year;
	private String month;
	private Float costOfSpCampAdwords;
	private Float costOfSpCampBanners;
	private Float costOfSpCampEmails;
	private Integer totalNoOfLeads;
	private Float costPerLeadOfAdwords;
	private Float costPerLeadOfBanners;
	private Float costPerLeadOfEmails;
	
}
