package com.snipecrm.kpi.marketing.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.snipecrm.kpi.marketing.service.MarketingService;

@RestController
@RequestMapping(value = "/kpi/marketing")
public class MarketingRestController {

	@Autowired
	private MarketingService markService;
	
	
	@GetMapping(value = "/costPerAcquisition/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CostPerAcquisition>> getCostPerAcquisition(@PathVariable("year") Integer year){
		List<CostPerAcquisition> acquisition = markService.calculateCostPerAcquisition(year);
		return new ResponseEntity<List<CostPerAcquisition>>(acquisition, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/costPerLead/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CostPerLead>> getCostPerLead(@PathVariable("year") Integer year){
		List<CostPerLead> lead = markService.calculateCostPerLead(year);
		return new ResponseEntity<List<CostPerLead>>(lead, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/avgOrderValue/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AverageOrderValue>> getAverageOrderValue(@PathVariable("year") Integer year){
		List<AverageOrderValue> orderValue = markService.calculateAverageOrderValue(year);
		return new ResponseEntity<List<AverageOrderValue>>(orderValue, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/returnOnInvestment/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReturnOnInvestment>> getReturnOnInvestment(@PathVariable("year") Integer year){
		List<ReturnOnInvestment> investment = markService.calculateReturnOnInvestment(year);
		return new ResponseEntity<List<ReturnOnInvestment>>(investment, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/websiteTrafficToLeadRatio/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WebsiteTrafficToLeadRatio>> getWebsiteTrafficToLeadRatio(@PathVariable("year") Integer year){
		List<WebsiteTrafficToLeadRatio> ratio = markService.calculateWebsiteTrafficToLeadRatio(year);
		return new ResponseEntity<List<WebsiteTrafficToLeadRatio>>(ratio, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/landingPageConversionRate/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LandingPageConversionRate>> getLandingPageConversionRate(@PathVariable("year") Integer year){
		List<LandingPageConversionRate> conversionRate = markService.calculateLandingPageConversionRate(year);
		return new ResponseEntity<List<LandingPageConversionRate>>(conversionRate, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/goalConversionRate/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<GoalConversionRate>> getGoalConversionRate(@PathVariable("year") Integer year){
		List<GoalConversionRate> rate = markService.calculateGoalConversionRate(year);
		return new ResponseEntity<List<GoalConversionRate>>(rate, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/avgTimeToConversion/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AverageTimeToConversion>> getAverageTimeToConversion(@PathVariable("year") Integer year){
		List<AverageTimeToConversion> conversion = markService.calculateAverageTimeToConversion(year);
		return new ResponseEntity<List<AverageTimeToConversion>>(conversion, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/costPerClick/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CostPerClick>> getCostPerClick(@PathVariable("year") Integer year){
		List<CostPerClick> costPerClick = markService.calculateCostPerClick(year);
		return new ResponseEntity<List<CostPerClick>>(costPerClick, HttpStatus.OK);
		
	}
	
	
	
	@GetMapping(value = "/bounceRate/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BounceRate>> getBounceRate(@PathVariable("year") Integer year){
		List<BounceRate> bounceRate = markService.calculateBounceRate(year);
		return new ResponseEntity<List<BounceRate>>(bounceRate, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/engagementRate/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EngagementRate>> getEngagementRate(@PathVariable("year") Integer year){
		List<EngagementRate> engagementRate = markService.calculateEngagementRate(year);
		return new ResponseEntity<List<EngagementRate>>(engagementRate, HttpStatus.OK);
	}
	
}
