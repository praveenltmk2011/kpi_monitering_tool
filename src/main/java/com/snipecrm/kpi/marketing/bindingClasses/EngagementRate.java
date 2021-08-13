package com.snipecrm.kpi.marketing.bindingClasses;

import lombok.Data;

@Data
public class EngagementRate {

	private Integer year;
	private String month;
	private Integer totalNoOfLikes;
	private Integer totalNoOfComments;
	private Integer totalNoOfShares;
	private Integer totalNoOfClicks;
	private Integer totalNoOfFollowers;
	private Float engagementRate;
	
}
