package com.snipecrm.kpi.marketing.bindingClasses;

import lombok.Data;

@Data
public class ReturnOnInvestment {

	private Integer year;
	private String month;
	private Float totalAmtSpent;
	private Float totalRevenue;
	private Integer returnOnInvestment;
}
