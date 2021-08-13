package com.snipecrm.kpi.marketing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.snipecrm.kpi.marketing.entities.MarketingConversions;
import com.snipecrm.kpi.marketing.entities.MarketingCustomer;
import com.snipecrm.kpi.marketing.entities.MarketingExpenditures;
import com.snipecrm.kpi.marketing.entities.MarketingRevenue;
import com.snipecrm.kpi.marketing.entities.MarketingTimestamp;
import com.snipecrm.kpi.marketing.repository.MarketingConversionsRepository;
import com.snipecrm.kpi.marketing.repository.MarketingCustomerRepository;
import com.snipecrm.kpi.marketing.repository.MarketingExpendituresRepository;
import com.snipecrm.kpi.marketing.repository.MarketingRevenueRepository;
import com.snipecrm.kpi.marketing.repository.MarketingTimestampRepository;

@Service
public class MarketingServiceImpl implements MarketingService {

	@Autowired
	private MarketingExpendituresRepository expRepo;
	
	@Autowired
	private MarketingConversionsRepository conRepo;
	
	@Autowired
	private MarketingCustomerRepository custRepo;
	
	@Autowired
	private MarketingRevenueRepository revRepo;
	
	@Autowired
	private MarketingTimestampRepository timeRepo;
	
	
	
	/**
	 * Calculating CostPerAcquisition
	 */
	@Override
	public List<CostPerAcquisition> calculateCostPerAcquisition(Integer year) {
				
		List<MarketingExpenditures> findByYear = expRepo.findByYear(year);
		
		List<MarketingConversions> findByYear2 = conRepo.findByYear(year);
		
		List<MarketingCustomer> findByYear3 = custRepo.findByYear(year);
		
		List<CostPerAcquisition> list = new ArrayList<CostPerAcquisition>();
		
		if(findByYear != null && findByYear2 != null && findByYear3 != null) {
			
			for(int i=0; i<findByYear.size(); i++) {
				MarketingExpenditures expenditures = findByYear.get(i);
				MarketingConversions conversions = findByYear2.get(i);
				MarketingCustomer customer = findByYear3.get(i);
				
				Float costPerAcquisition = expenditures.getTotalAmtSpent() / conversions.getTotalNoOfConversions();
				
				CostPerAcquisition cpa = new CostPerAcquisition();
				cpa.setYear(expenditures.getYear());
				cpa.setMonth(expenditures.getMonth());
				cpa.setTotalAmtSpent(expenditures.getTotalAmtSpent());
				cpa.setTotalNoOfConversions(conversions.getTotalNoOfConversions());
				cpa.setTotalNoOfVisitors(customer.getTotalNoOfVisitors());
				cpa.setCostPerAcquisition(costPerAcquisition);
				
				list.add(cpa);
			}
		}
		
		return list;
	}
	
	
	
	/**
	 * Calculating CostPerLead
	 */
	public List<CostPerLead> calculateCostPerLead(Integer year) {
		
		List<MarketingExpenditures> findByYear = expRepo.findByYear(year);
		
		List<MarketingConversions> findByYear2 = conRepo.findByYear(year);
		
		List<CostPerLead> list = new ArrayList<CostPerLead>();
		
		if(findByYear != null && findByYear2 != null) {
			for(int i=0; i<findByYear.size(); i++) {
				MarketingExpenditures expenditures = findByYear.get(i);
				MarketingConversions conversions = findByYear2.get(i);
				
				Float costPerLeadOfAdwords = expenditures.getCostOfSpCampAdwords() / conversions.getTotalNoOfLeads();
				
				Float costPerLeadOfBanners = expenditures.getCostOfSpCampBanners() / conversions.getTotalNoOfLeads();
				
				Float costPerLeadOfEmails = expenditures.getCostOfSpCampEmails() / conversions.getTotalNoOfLeads();
				
				CostPerLead cpl = new CostPerLead();
				 cpl.setYear(expenditures.getYear());
				 cpl.setMonth(expenditures.getMonth());
				 cpl.setCostOfSpCampAdwords(expenditures.getCostOfSpCampAdwords());
				 cpl.setCostOfSpCampBanners(expenditures.getCostOfSpCampBanners());
				 cpl.setCostOfSpCampEmails(expenditures.getCostOfSpCampEmails());
				 cpl.setTotalNoOfLeads(conversions.getTotalNoOfLeads());
				 cpl.setCostPerLeadOfAdwords(costPerLeadOfAdwords);
				 cpl.setCostPerLeadOfBanners(costPerLeadOfBanners);
				 cpl.setCostPerLeadOfEmails(costPerLeadOfEmails);
				 
				 list.add(cpl);
			}
		}
		return list;
	}
	
	
	
	/**
	 * Calculating AverageOrderValue
	 */
	public List<AverageOrderValue> calculateAverageOrderValue(Integer year) {
		
		List<MarketingRevenue> findByYear = revRepo.findByYear(year);
		
		List<MarketingConversions> findByYear2 = conRepo.findByYear(year);
		
		List<AverageOrderValue> list = new ArrayList<AverageOrderValue>();
		
		if(findByYear != null && findByYear2 != null) {
			for(int i=0; i<findByYear.size(); i++) {
				MarketingRevenue revenue = findByYear.get(i);
				MarketingConversions conversions = findByYear2.get(i);
				
				Float avgOrderValueOrganic = revenue.getTotalRevOfOrganicChl() / conversions.getNumOfOrderPlaced();
				
				Float avgOrderValueSocial = revenue.getTotalRevOfSocialChl() / conversions.getNumOfOrderPlaced();
				
				Float avgOrderValueDirect = revenue.getTotalRevOfDirectChl() / conversions.getNumOfOrderPlaced();
				
				Float avgOrderValuePaid = revenue.getTotalRevOfPaidChl() / conversions.getNumOfOrderPlaced();
				
				Float avgOrderValueReferral = revenue.getTotalRevOfReferralChl() / conversions.getNumOfOrderPlaced();
				
				Float actualAvg = (avgOrderValueOrganic + avgOrderValueSocial + avgOrderValueDirect + avgOrderValuePaid + avgOrderValueReferral) / 5;
				
				Integer targetAvg = 40;
				Float toTarget = ((actualAvg - targetAvg) * 100)/targetAvg;
				
				AverageOrderValue aov = new AverageOrderValue();
				aov.setYear(revenue.getYear());
				aov.setMonth(revenue.getMonth());
				aov.setTotalRevOfOrganicChl(revenue.getTotalRevOfOrganicChl());
				aov.setTotalRevOfSocialChl(revenue.getTotalRevOfSocialChl());
				aov.setTotalRevOfDirectChl(revenue.getTotalRevOfDirectChl());
				aov.setTotalRevOfPaidChl(revenue.getTotalRevOfPaidChl());
				aov.setTotalRevOfReferralChl(revenue.getTotalRevOfReferralChl());
				aov.setTotalRevOfAllChl(revenue.getTotalRevOfAllChl());
				aov.setNumOfOrderPlaced(conversions.getNumOfOrderPlaced());
				aov.setAvgOrderValueOrganic(avgOrderValueOrganic);
				aov.setAvgOrderValueSocial(avgOrderValueSocial);
				aov.setAvgOrderValueDirect(avgOrderValueDirect);
				aov.setAvgOrderValuePaid(avgOrderValuePaid);
				aov.setAvgOrderValueReferral(avgOrderValueReferral);
				aov.setActualAvg(actualAvg);
				aov.setTargetAvg(targetAvg);
				aov.setToTarget(toTarget);
				
				list.add(aov);
			}
		}
		return list;
	}
	
	
	
	/**
	 * Calculating ReturnOnInvestment
	 */
	public List<ReturnOnInvestment> calculateReturnOnInvestment(Integer year) {
		
		List<MarketingExpenditures> findByYear = expRepo.findByYear(year);
		
		List<MarketingRevenue> findByYear2 = revRepo.findByYear(year);
		
		List<ReturnOnInvestment> list = new ArrayList<ReturnOnInvestment>();
		
		if(findByYear != null && findByYear2 != null) {
			for(int i=0; i<findByYear.size(); i++) {
				MarketingExpenditures expenditure = findByYear.get(i);
				MarketingRevenue revenue = findByYear2.get(i);
				
				Integer returnOnInvestment = Math.round(((revenue.getTotalRevenue() - expenditure.getTotalAmtSpent()) * 100) / expenditure.getTotalAmtSpent());
				
				ReturnOnInvestment roi = new ReturnOnInvestment();
				roi.setYear(revenue.getYear());
				roi.setMonth(revenue.getMonth());
				roi.setTotalAmtSpent(expenditure.getTotalAmtSpent());
				roi.setTotalRevenue(revenue.getTotalRevenue());
				roi.setReturnOnInvestment(returnOnInvestment);
				
				list.add(roi);
			}
		}
		return list;
	}
	
	
	
	/**
	 * Calculating WebsiteTrafficToLeadRatio
	 */
	public List<WebsiteTrafficToLeadRatio> calculateWebsiteTrafficToLeadRatio(Integer year) {
		
		List<MarketingConversions> findByYear = conRepo.findByYear(year);
		
		List<MarketingCustomer> findByYear2 = custRepo.findByYear(year);
		
		List<WebsiteTrafficToLeadRatio> list = new ArrayList<WebsiteTrafficToLeadRatio>();
		
		if(findByYear != null && findByYear2 != null) {
			for(int i=0; i<findByYear.size(); i++) {
				MarketingConversions conversions = findByYear.get(i);
				MarketingCustomer customer = findByYear2.get(i);
				
				Integer websiteTrafficToLeadRatio = (conversions.getTotalNoOfLeads() * 100) / customer.getTotalNoOfVisitors();
				
				WebsiteTrafficToLeadRatio wtr = new WebsiteTrafficToLeadRatio();
				wtr.setYear(conversions.getYear());
				wtr.setMonth(conversions.getMonth());
				wtr.setTotalNoOfLeads(conversions.getTotalNoOfLeads());
				wtr.setTotalNoOfVisitors(customer.getTotalNoOfVisitors());
				wtr.setWebsiteTrafficToLeadRatio(websiteTrafficToLeadRatio);
				
				list.add(wtr);
			}
		}
		return list;
	}
	
	
	
	/**
	 * Calculating LandingPageConversionRate
	 */
	public List<LandingPageConversionRate> calculateLandingPageConversionRate(Integer year) {
		
		List<MarketingConversions> findByYear = conRepo.findByYear(year);
		
		List<MarketingCustomer> findByYear2 = custRepo.findByYear(year);
		
		List<LandingPageConversionRate> list = new ArrayList<LandingPageConversionRate>();
		
		if(findByYear != null && findByYear2 != null) {
			for(int i=0; i<findByYear.size(); i++) {
				MarketingConversions conversions = findByYear.get(i);
				MarketingCustomer customer = findByYear2.get(i);
				
				Integer landingPageConversionRate = (conversions.getTotalNoOfConversions() * 100)/ customer.getTotalNoOfVisitors();
				
				LandingPageConversionRate lcr = new LandingPageConversionRate();
				lcr.setYear(conversions.getYear());
				lcr.setMonth(conversions.getMonth());
				lcr.setTotalNoOfVisitors(customer.getTotalNoOfVisitors());
				lcr.setTotalNoOfConversions(conversions.getTotalNoOfConversions());
				lcr.setLandingPageConversionRate(landingPageConversionRate);
				
				list.add(lcr);
			}
		}
		return list;
	}
	
	
	
	/**
	 * Calculating GoalConversionRate
	 */
	public List<GoalConversionRate> calculateGoalConversionRate(Integer year) {
		
		List<MarketingConversions> findByYear = conRepo.findByYear(year);
		
		List<MarketingCustomer> findByYear2 = custRepo.findByYear(year);
		
		List<GoalConversionRate> list = new ArrayList<GoalConversionRate>();
		
		if(findByYear != null && findByYear2 != null) {
			for(int i=0; i<findByYear.size(); i++) {
				MarketingConversions conversions = findByYear.get(i);
				MarketingCustomer customer = findByYear2.get(i);
				
				Float goalConversionRate = (float)((conversions.getTotalNoOfConversions() * 100) / customer.getTotalNoOfVisitors());
				
				GoalConversionRate gcr = new GoalConversionRate();
				gcr.setYear(conversions.getYear());
				gcr.setMonth(conversions.getMonth());
				gcr.setTotalNoOfConversions(conversions.getTotalNoOfConversions());
				gcr.setTotalNoOfVisitors(customer.getTotalNoOfVisitors());
				gcr.setGoalConversionRate(goalConversionRate);
				
				list.add(gcr);
			}
		}
		return list;
	}
	
	
	
	
	/**
	 * Calculating AverageTimeToConversion
	 */
	public List<AverageTimeToConversion> calculateAverageTimeToConversion(Integer year) {
		
		List<MarketingTimestamp> findByYear = timeRepo.findByYear(year);
		
		List<MarketingConversions> findByYear2 = conRepo.findByYear(year);
		
		List<AverageTimeToConversion> list = new ArrayList<AverageTimeToConversion>();
		
		if(findByYear != null && findByYear2 != null) {
			for(int i=0; i<findByYear.size(); i++) {
				MarketingTimestamp totalTime = findByYear.get(i);
				MarketingConversions conversions = findByYear2.get(i);
				
				Long avgTimeToConversion = totalTime.getTotalTimetakenForConversion() / conversions.getTotalNoOfConversions();
				
				AverageTimeToConversion atc = new AverageTimeToConversion();
				atc.setYear(totalTime.getYear());
				atc.setMonth(totalTime.getMonth());
				atc.setTotalTimetakenForConversion(totalTime.getTotalTimetakenForConversion());
				atc.setTotalNoOfConversion(conversions.getTotalNoOfConversions());
				atc.setAvgTimeToConversion(avgTimeToConversion);
				
				list.add(atc);
			}
		}
		return list;
	}
	
	
	
	
	/**
	 * Calculating CostPerClick
	 */
	public List<CostPerClick> calculateCostPerClick(Integer year) {
		
		List<MarketingTimestamp> findByYear = timeRepo.findByYear(year);
		
		List<MarketingExpenditures> findByYear2 = expRepo.findByYear(year);
		
		List<CostPerClick> list = new ArrayList<CostPerClick>();
		
		if(findByYear != null && findByYear2 != null) {
			for(int i=0; i<findByYear.size(); i++) {
				MarketingTimestamp time = findByYear.get(i);
				MarketingExpenditures expenditure = findByYear2.get(i);
				
				Float costPerClick = expenditure.getTotalAmtSpent() / time.getTotalMeasurableClicks();
				
				CostPerClick cpc = new CostPerClick();
				cpc.setYear(time.getYear());
				cpc.setMonth(time.getMonth());
				cpc.setTotalAmtSpent(expenditure.getTotalAmtSpent());
				cpc.setTotalMeasurableClicks(time.getTotalMeasurableClicks());
				cpc.setCostPerClick(costPerClick);
				
				list.add(cpc);
			}
		}
		return list;
	}
	
	
	
	
	
	/**
	 * Calculating BounceRate
	 */
	public List<BounceRate> calculateBounceRate(Integer year) {
		
		List<MarketingCustomer> findByYear = custRepo.findByYear(year);
		
		List<BounceRate> list = new ArrayList<BounceRate>();
		
		if(findByYear != null) {
			for(MarketingCustomer customer : findByYear) {
				Integer bounceRate = (customer.getTotalNoOfVisitorsWithoutInteraction() * 100) / customer.getTotalNoOfVisitors();
				
				BounceRate br = new BounceRate();
				br.setYear(customer.getYear());
				br.setMonth(customer.getMonth());
				br.setTotalVisitosWithoutInteraction(customer.getTotalNoOfVisitorsWithoutInteraction());
				br.setTotalNoOfVisitors(customer.getTotalNoOfVisitors());
				br.setBounceRate(bounceRate);
				
				list.add(br);
			}
		}
		return list;
	}
	
	
	
	
	/**
	 * Calculating EngagementRate
	 */
	public List<EngagementRate> calculateEngagementRate(Integer year) {
		
		List<MarketingCustomer> findByYear = custRepo.findByYear(year);
		
		List<EngagementRate> list = new ArrayList<EngagementRate>();
		
		if(findByYear != null) {
			for(MarketingCustomer entity : findByYear) {
				Integer totalEngagedCustomers = entity.getTotalNoOfLikes() + entity.getTotalNoOfComments() + entity.getTotalNoOfShares() + entity.getTotalNoOfClicks();
			
				Float engagementRate = (float)(totalEngagedCustomers * 100) / entity.getTotalNoOfFollowers();
			
				EngagementRate er = new EngagementRate();
				er.setYear(entity.getYear());
				er.setMonth(entity.getMonth());
				er.setTotalNoOfLikes(entity.getTotalNoOfLikes());
				er.setTotalNoOfComments(entity.getTotalNoOfComments());
				er.setTotalNoOfShares(entity.getTotalNoOfShares());
				er.setTotalNoOfClicks(entity.getTotalNoOfClicks());
				er.setTotalNoOfFollowers(entity.getTotalNoOfFollowers());
				er.setEngagementRate(engagementRate);
			
				list.add(er);
			}
		}
		return list;
	}
	
	
	
	
	
	
	

}
