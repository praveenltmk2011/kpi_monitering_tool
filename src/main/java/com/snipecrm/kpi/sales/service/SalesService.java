package com.snipecrm.kpi.sales.service;

import java.util.List;

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

public interface SalesService {

	public List<SalesGrowth> calculateSalesGrowth(Integer year);
	
	public List<SalesTarget> calculateSalesTarget(Integer year);
	
	public List<CustomerAcquisitionCost> calculateCustomerAcquisitionCost(Integer year);
	
	public List<SalesStaffData> retrieveSalesStaffData(String salesPersonName);
	
	public List<AverageRevenuePerUnit> calculateAverageRevenuePerUnit(Integer year);
	
	public List<CustomerLifetimeValue> calculateCustomerLifetimeValue(Integer year);
	
	public List<CustomerChurnRate> calculateCustomerChurnRate(Integer year);
	
	public List<LeadToOpportunityRatio> calculateLeadToOpportunityRatio(Integer year);
	
	public List<OpportunitiesToWinRatio> calculateOpportunitesToWinRatio(Integer year);
	
	public List<LeadConversionRatio> calculateLeadConversionRatio(Integer year);
	
	public List<SalesOpportunity> calculateSalesOpportunity(Integer year);
	
	//public List<SalesStaffData> retrieveSalesStaffData(String salesPersonName, Date fromDate, Date toDate);
	
	
}
