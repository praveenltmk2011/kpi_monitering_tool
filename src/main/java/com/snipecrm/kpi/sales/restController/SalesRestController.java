package com.snipecrm.kpi.sales.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snipecrm.kpi.sales.bindingClasses.AverageRevenuePerUnit;
import com.snipecrm.kpi.sales.bindingClasses.CustomerAcquisitionCost;
import com.snipecrm.kpi.sales.bindingClasses.CustomerChurnRate;
import com.snipecrm.kpi.sales.bindingClasses.CustomerLifetimeValue;
import com.snipecrm.kpi.sales.bindingClasses.LeadConversionRatio;
import com.snipecrm.kpi.sales.bindingClasses.LeadToOpportunityRatio;
import com.snipecrm.kpi.sales.bindingClasses.OpportunitiesToWinRatio;
import com.snipecrm.kpi.sales.bindingClasses.SalesGrowth;
import com.snipecrm.kpi.sales.bindingClasses.SalesOpportunity;
import com.snipecrm.kpi.sales.bindingClasses.SalesStaffData;
import com.snipecrm.kpi.sales.bindingClasses.SalesTarget;
import com.snipecrm.kpi.sales.service.SalesService;

@RestController
@RequestMapping(value = "/kpi/sales")
public class SalesRestController {

	@Autowired
	private SalesService salesService;
	
	
	@GetMapping(value = "/salesGrowth/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SalesGrowth>> getSalesGrowth(@PathVariable("year") Integer year){
		List<SalesGrowth> growth = salesService.calculateSalesGrowth(year);
		return new ResponseEntity<List<SalesGrowth>>(growth, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/salesTarget/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SalesTarget>> getSalesTarget(@PathVariable("year") Integer year){
		List<SalesTarget> target = salesService.calculateSalesTarget(year);
		return new ResponseEntity<List<SalesTarget>>(target, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/customerAcquistionCost/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CustomerAcquisitionCost>> getCustomerAcquisitionCost(@PathVariable("year") Integer year){
		List<CustomerAcquisitionCost> cost = salesService.calculateCustomerAcquisitionCost(year);
		return new ResponseEntity<List<CustomerAcquisitionCost>>(cost, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/avgRevenuePerUnit/{year}")
	public ResponseEntity<List<AverageRevenuePerUnit>> getAverageRevenuePerUnit(@PathVariable("year") Integer year){
		List<AverageRevenuePerUnit> unit = salesService.calculateAverageRevenuePerUnit(year);
		return new ResponseEntity<List<AverageRevenuePerUnit>>(unit, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/customerLifetimeValue/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CustomerLifetimeValue>> getCustomerLifetimeValue(@PathVariable("year") Integer year){
		List<CustomerLifetimeValue> value = salesService.calculateCustomerLifetimeValue(year);
		return new ResponseEntity<List<CustomerLifetimeValue>>(value, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/customerChurnRate/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CustomerChurnRate>> getCustomerChurnRate(@PathVariable("year") Integer year){
		List<CustomerChurnRate> churnRate = salesService.calculateCustomerChurnRate(year);
		return new ResponseEntity<List<CustomerChurnRate>>(churnRate, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/leadToOpportunityRatio/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LeadToOpportunityRatio>> getLeadToOpportunityRatio(@PathVariable("year") Integer year){
		List<LeadToOpportunityRatio> ratio = salesService.calculateLeadToOpportunityRatio(year);
		return new ResponseEntity<List<LeadToOpportunityRatio>>(ratio, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/opportunitiesToWinRatio/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OpportunitiesToWinRatio>> getOpportunitiesToWinRatio(@PathVariable("year") Integer year){
		List<OpportunitiesToWinRatio> winRatio = salesService.calculateOpportunitesToWinRatio(year);
		return new ResponseEntity<List<OpportunitiesToWinRatio>>(winRatio, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/leadConversionRatio/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LeadConversionRatio>> getLeadConversionRatio(@PathVariable("year") Integer year){
		List<LeadConversionRatio> conversionRatio = salesService.calculateLeadConversionRatio(year);
		return new ResponseEntity<List<LeadConversionRatio>>(conversionRatio, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/salesOpportunity/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SalesOpportunity>> getSalesOpportunity(@PathVariable("year") Integer year){
		List<SalesOpportunity> opportunity = salesService.calculateSalesOpportunity(year);
		return new ResponseEntity<List<SalesOpportunity>>(opportunity, HttpStatus.OK);
	}
	
	
	
 	
	@GetMapping(value = "/salesStaffData/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SalesStaffData>> getSalesStaffData(@PathVariable("name") String salesPersonName){
		List<SalesStaffData> staffData = salesService.retrieveSalesStaffData(salesPersonName);
		return new ResponseEntity<List<SalesStaffData>>(staffData, HttpStatus.OK);
	}
}
