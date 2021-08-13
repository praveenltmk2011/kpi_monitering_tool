package com.snipecrm.kpi.marketing.service;

import java.util.List;

import com.snipecrm.kpi.marketing.bindingClasses.AverageOrderValue;
import com.snipecrm.kpi.marketing.bindingClasses.AverageTimeToConversion;
import com.snipecrm.kpi.marketing.bindingClasses.BounceRate;
import com.snipecrm.kpi.marketing.bindingClasses.CostPerAcquisition;
import com.snipecrm.kpi.marketing.bindingClasses.CostPerClick;
import com.snipecrm.kpi.marketing.bindingClasses.CostPerLead;
import com.snipecrm.kpi.marketing.bindingClasses.EngagementRate;
import com.snipecrm.kpi.marketing.bindingClasses.GoalConversionRate;
import com.snipecrm.kpi.marketing.bindingClasses.LandingPageConversionRate;
import com.snipecrm.kpi.marketing.bindingClasses.ReturnOnInvestment;
import com.snipecrm.kpi.marketing.bindingClasses.WebsiteTrafficToLeadRatio;

public interface MarketingService {

	public List<CostPerAcquisition> calculateCostPerAcquisition(Integer year);
	
	public List<CostPerLead> calculateCostPerLead(Integer year);
	
	public List<AverageOrderValue> calculateAverageOrderValue(Integer year);
	
	public List<ReturnOnInvestment> calculateReturnOnInvestment(Integer year);
	
	public List<WebsiteTrafficToLeadRatio> calculateWebsiteTrafficToLeadRatio(Integer year);
	
	public List<LandingPageConversionRate> calculateLandingPageConversionRate(Integer year);
	
	public List<GoalConversionRate> calculateGoalConversionRate(Integer year);
	
	public List<AverageTimeToConversion> calculateAverageTimeToConversion(Integer year);
	
	public List<CostPerClick> calculateCostPerClick(Integer year);
	
	public List<BounceRate> calculateBounceRate(Integer year);
	
	public List<EngagementRate> calculateEngagementRate(Integer year);
	
}
