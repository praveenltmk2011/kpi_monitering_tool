package com.snipecrm.kpi.marketing.bindingClasses;

import lombok.Data;

@Data
public class AverageOrderValue {

	private Integer year;
	private String month;
	private Float totalRevOfOrganicChl;
	private Float totalRevOfSocialChl;
	private Float totalRevOfDirectChl;
	private Float totalRevOfPaidChl;
	private Float totalRevOfReferralChl;
	private Float totalRevOfAllChl;
	private Integer NumOfOrderPlaced;
	private Float avgOrderValueOrganic;
	private Float avgOrderValueSocial;
	private Float avgOrderValueDirect;
	private Float avgOrderValuePaid;
	private Float avgOrderValueReferral;
	private Float actualAvg;
	private Integer targetAvg;
	private Float ToTarget;

}
