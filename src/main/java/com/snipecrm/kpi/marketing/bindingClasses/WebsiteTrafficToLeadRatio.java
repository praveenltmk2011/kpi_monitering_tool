package com.snipecrm.kpi.marketing.bindingClasses;

import lombok.Data;

@Data
public class WebsiteTrafficToLeadRatio {

	private Integer year;
	private String month;
	private Integer totalNoOfVisitors;
	private Integer totalNoOfLeads;
	private Integer websiteTrafficToLeadRatio;
}
