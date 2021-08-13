package com.snipecrm.kpi.sales.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.plaf.ScrollBarUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.snipecrm.kpi.sales.entities.SalesConversions;
import com.snipecrm.kpi.sales.entities.SalesCustomer;
import com.snipecrm.kpi.sales.entities.SalesExpenditure;
import com.snipecrm.kpi.sales.entities.SalesRevenue;
import com.snipecrm.kpi.sales.entities.SalesStaff;
import com.snipecrm.kpi.sales.repository.SalesConversiionsRepository;
import com.snipecrm.kpi.sales.repository.SalesCustomerRepository;
import com.snipecrm.kpi.sales.repository.SalesExpenditureRepository;
import com.snipecrm.kpi.sales.repository.SalesIndirectExpensesRepository;
import com.snipecrm.kpi.sales.repository.SalesRevenueRepository;
import com.snipecrm.kpi.sales.repository.SalesStaffRepository;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	private SalesRevenueRepository revRepo;
	
	@Autowired
	private SalesExpenditureRepository expRepo;
	
	@Autowired
	private SalesIndirectExpensesRepository indExpRepo;
	
	@Autowired
	private SalesCustomerRepository custRepo;
	
	@Autowired
	private SalesConversiionsRepository conRepo;
	
	@Autowired
	private SalesStaffRepository staffRepo;
	
	
	/**
	 * Calculating Sales Growth
	 */
	public List<SalesGrowth> calculateSalesGrowth(Integer year){
		List<SalesRevenue> findByYear = revRepo.findByYear(year);
		
		List<SalesGrowth> list = new ArrayList<SalesGrowth>();
		
		for(int i=0; i<findByYear.size(); i++) {
			SalesRevenue revenue = findByYear.get(i);
			
			Integer salesGrowth = (revenue.getCurrentPeriodSales() - revenue.getPriorPeriodSales()) * 100 / revenue.getPriorPeriodSales();
			
			SalesGrowth sg = new SalesGrowth();
			sg.setYear(revenue.getYear());
			sg.setMonth(revenue.getMonth());
			sg.setCurrentPeriodSales(revenue.getCurrentPeriodSales());
			sg.setPriorPeriodSales(revenue.getPriorPeriodSales());
			sg.setSalesGrowth(salesGrowth);
			
			list.add(sg);
		}
		return list;
	}
	
	
	
	
	/**
	 * Calculating Sales Target %
	 */
	@Override
	public List<SalesTarget> calculateSalesTarget(Integer year) {
		List<SalesRevenue> findByYear = revRepo.findByYear(year);
		
		List<SalesCustomer> findByYear2 = custRepo.findByYear(year);
		
		List<SalesTarget> list = new ArrayList<SalesTarget>();
		
		for(int i=0; i<findByYear.size(); i++) {
			SalesRevenue revenue = findByYear.get(i);
			SalesCustomer customer = findByYear2.get(i);
			
			Integer salesTarget = (revenue.getCurrentPeriodSales() * 100) / revenue.getSalesTarget();
			
			SalesTarget st = new SalesTarget();
			st.setYear(revenue.getYear());
			st.setMonth(revenue.getMonth());
			st.setNewCustomersAcquired(customer.getNewCustomersAcquired());
			st.setCurrentPeriodSales(revenue.getCurrentPeriodSales());
			st.setSalesRevenue(revenue.getSalesRevenue());
			st.setTargetSet(revenue.getSalesTarget());
			st.setSalesTarget(salesTarget);
			
			list.add(st);
		}
		return list;
	}
	
	
	
	/**
	 * Calculating Customer Acquisition Cost
	 */
	@Override
	public List<CustomerAcquisitionCost> calculateCustomerAcquisitionCost(Integer year) {
		List<SalesExpenditure> findByYear = expRepo.findByYear(year);
		
		List<SalesCustomer> findByYear2 = custRepo.findByYear(year);
		
		List<CustomerAcquisitionCost> list = new ArrayList<CustomerAcquisitionCost>();
		
		for(int i=0; i<findByYear.size(); i++) {
			SalesExpenditure expenditure = findByYear.get(i);
			SalesCustomer customer = findByYear2.get(i);
			
			Float customerAcquisitionCost = (expenditure.getCostOfSales() + expenditure.getCostOfMarketing()) / customer.getNewCustomersAcquired();
			
			CustomerAcquisitionCost cac = new CustomerAcquisitionCost();
			cac.setYear(expenditure.getYear());
			cac.setMonth(expenditure.getMonth());
			cac.setNewCustomersAcquired(customer.getNewCustomersAcquired());
			cac.setCostOfSales(expenditure.getCostOfSales());
			cac.setCostOfMarketing(expenditure.getCostOfMarketing());
			cac.setCustomerAcquisitionCost(customerAcquisitionCost);
			
			list.add(cac);
		}
		return list;
	}
	
	
	
	/**
	 * Calculating Average Revenue Per Unit
	 */
	@Override
	public List<AverageRevenuePerUnit> calculateAverageRevenuePerUnit(Integer year) {
		List<SalesRevenue> findByYear = revRepo.findByYear(year);
		
		List<AverageRevenuePerUnit> list = new ArrayList<AverageRevenuePerUnit>();
		
		for(int i=0; i<findByYear.size(); i++) {
			SalesRevenue revenue = findByYear.get(i);
			
			Integer avgRevenuePerUnit = Math.round(revenue.getSalesRevenue() / revenue.getNoOfUnitsSold());
			
			AverageRevenuePerUnit aru = new AverageRevenuePerUnit();
			aru.setYear(revenue.getYear());
			aru.setMonth(revenue.getMonth());
			aru.setTotalSalesRevenue(revenue.getSalesRevenue());
			aru.setNoOfUnitsSold(revenue.getNoOfUnitsSold());
			aru.setAvgRevenuePerUnit(avgRevenuePerUnit);
			
			list.add(aru);
		}
		return list;
	}
	
	
	
	/**
	 * Calculating Customer Lifetime Value
	 */
	@Override
	public List<CustomerLifetimeValue> calculateCustomerLifetimeValue(Integer year) {
		List<SalesCustomer> findByYear = custRepo.findByYear(year);
		
		List<CustomerLifetimeValue> list = new ArrayList<CustomerLifetimeValue>();
		
		for(int i=0; i<findByYear.size(); i++) {
			SalesCustomer customer = findByYear.get(i);
			
			Integer customerLifetimeValue = Math.round(customer.getAvgPurchaseValue() * customer.getAvgPurchaseFreqRate() * customer.getAvgCustomerLifespan());
			
			CustomerLifetimeValue clv = new CustomerLifetimeValue();
			clv.setYear(customer.getYear());
			clv.setMonth(customer.getMonth());
			clv.setAvgPurchaseValue(customer.getAvgPurchaseValue());
			clv.setAvgPurchaseFreqRate(customer.getAvgPurchaseFreqRate());
			clv.setAvgCustomerLifespan(customer.getAvgCustomerLifespan());
			clv.setCustomerLifetimeValue(customerLifetimeValue);
			
			list.add(clv);
			
		}
		return list;
	}
	
	
	
	/**
	 * Calculating Customer Churn Rate
	 */
	@Override
	public List<CustomerChurnRate> calculateCustomerChurnRate(Integer year) {
		List<SalesCustomer> findByYear = custRepo.findByYear(year);
		
		List<SalesRevenue> findByYear2 = revRepo.findByYear(year);
		
		List<CustomerChurnRate> list = new ArrayList<CustomerChurnRate>();
		
		for(int i=0; i<findByYear.size(); i++) {
			SalesCustomer customer = findByYear.get(i);
			
			SalesRevenue revenue = findByYear2.get(i);
			
			Integer customerChurnRate = customer.getPriorCustomers() / customer.getCustomerLost();
			
			Integer revenueLost = Math.round((revenue.getSalesRevenue() / customer.getPriorCustomers()) * customer.getCustomerLost());
			
			CustomerChurnRate ccr = new CustomerChurnRate();
			ccr.setYear(customer.getYear());
			ccr.setMonth(customer.getMonth());
			ccr.setCustomersAtBeginning(customer.getPriorCustomers());
			ccr.setCustomersLost(customer.getCustomerLost());
			ccr.setRevenueLost(revenueLost);
			ccr.setCustomerChurnRate(customerChurnRate);
			
			list.add(ccr);
		}
		return list;
	}
	
	
	
	
	/**
	 * Calculating Average Sales Cycle Length
	 */
	
	
	
	
	
	
	
	
	
	/**
	 * Calculating Lead-To-Opportunity-Ratio
	 */
	@Override
	public List<LeadToOpportunityRatio> calculateLeadToOpportunityRatio(Integer year) {
		List<SalesConversions> findByYear = conRepo.findByYear(year);
		
		List<LeadToOpportunityRatio> list = new ArrayList<LeadToOpportunityRatio>();
		
		for(int i=0; i<findByYear.size(); i++) {
			SalesConversions conversions = findByYear.get(i);
			
			Integer leadsToOpportunityRatio = (conversions.getTotalNoOfOpportunities() * 100) / conversions.getTotalNoOfLeads();
			
			Integer LeadToOpportunity = conversions.getTotalNoOfLeads() / conversions.getTotalNoOfOpportunities();
			
			LeadToOpportunityRatio lor = new LeadToOpportunityRatio();
			lor.setYear(conversions.getYear());
			lor.setMonth(conversions.getMonth());
			lor.setLeadConv2Opportunities(conversions.getTotalNoOfOpportunities());
			lor.setLeadToOpportunity(LeadToOpportunity);
			lor.setLeadsToOpportunityRatio(leadsToOpportunityRatio);
			
			list.add(lor);
		}
		return list;
	}
	
	
	
	
	/**
	 * Calculating Opportunities-To-Win-Ratio
	 */
	@Override
	public List<OpportunitiesToWinRatio> calculateOpportunitesToWinRatio(Integer year) {
		List<SalesConversions> findByYear = conRepo.findByYear(year);
		
		List<OpportunitiesToWinRatio> list = new ArrayList<OpportunitiesToWinRatio>();
		
		for(int i=0; i<findByYear.size(); i++) {
			SalesConversions conversions = findByYear.get(i);
			
			Integer opportunitiesToWinRatio = (conversions.getTotalNoOfWins() * 100) / conversions.getTotalNoOfOpportunities();
			
			OpportunitiesToWinRatio owr = new OpportunitiesToWinRatio();
			owr.setYear(conversions.getYear());
			owr.setMonth(conversions.getMonth());
			owr.setTotalNoOfOpportunities(conversions.getTotalNoOfOpportunities());
			owr.setNoOfOpportunitesWon(conversions.getTotalNoOfWins());
			owr.setOpportunitiesToWinRatio(opportunitiesToWinRatio);
			
			list.add(owr);
		}
		return list;
	}
	
	
	
	/**
	 * Calculating LeadConversionRatio
	 */
	@Override
	public List<LeadConversionRatio> calculateLeadConversionRatio(Integer year) {
		List<SalesConversions> findByYear = conRepo.findByYear(year);
		
		List<LeadConversionRatio> list = new ArrayList<LeadConversionRatio>();
		
		for(int i=0; i<findByYear.size(); i++) {
			SalesConversions conversions = findByYear.get(i);
			
			Integer leadConversionRatio = (conversions.getTotalNoOfOpportunities() * 100) / conversions.getTotalNoOfLeads();
			
			LeadConversionRatio lcr = new LeadConversionRatio();
			lcr.setYear(conversions.getYear());
			lcr.setMonth(conversions.getMonth());
			lcr.setLeadsConvertedToOpportunites(conversions.getTotalNoOfOpportunities());
			lcr.setTotalNoOfLeads(conversions.getTotalNoOfLeads());
			lcr.setLeadConversionRatio(leadConversionRatio);
			
			list.add(lcr);
		}
		return list;
	}
	
	
	
	
	/**
	 * Calculating Sales Opportunity
	 */
	@Override
	public List<SalesOpportunity> calculateSalesOpportunity(Integer year) {
		List<SalesConversions> findByYear = conRepo.findByYear(year);
		
		List<SalesOpportunity> list = new ArrayList<SalesOpportunity>();
		
		for(int i=0; i<findByYear.size(); i++) {
			SalesConversions conversions = findByYear.get(i);
			
			Integer noOfSalesOpportunity = (conversions.getTotalSalesActLogged() * 100) / conversions.getTotalNoOfOpportunities();
			
			SalesOpportunity so = new SalesOpportunity();
			so.setYear(conversions.getYear());
			so.setMonth(conversions.getMonth());
			so.setTotalSalesActivitiesLogged(conversions.getTotalSalesActLogged());
			so.setTotalNoOpportunities(conversions.getTotalNoOfOpportunities());
			so.setNoOfSalesOpportunity(noOfSalesOpportunity);
			
			list.add(so);
		}
		return list;
	}
	
	
	
	
	/**
	 * Sending Sales Person wise data
	 */
	@Override
	public List<SalesStaffData> retrieveSalesStaffData(String salesPersonName){
			List<SalesStaff> salesStaff = staffRepo.findBySalesPersonName(salesPersonName);
		
			List<SalesStaffData> list = new ArrayList<SalesStaffData>();
			if(salesStaff != null) {
				for(int i=0; i<salesStaff.size(); i++) {
					SalesStaff data = salesStaff.get(i);
				
					SalesStaffData staffData = new SalesStaffData();
					staffData.setYear(data.getYear());
					staffData.setMonth(data.getMonth());
					staffData.setSalesPersonName(data.getSalesPersonName());
					staffData.setDesignation(data.getDesignation());
					staffData.setState(data.getState());
					staffData.setTargets(data.getTargets());
					staffData.setAchievements(data.getAchievements());
					staffData.setDate(data.getDate());
					staffData.setNoOfOrders(data.getNoOfOrders());
					staffData.setTotalSalesCost(data.getSalesCost());
					staffData.setSalesProfit(data.getSalesProfit());
					staffData.setCommissionPaid(data.getCommissionPaid());
				
					list.add(staffData);
				}
			}
			return list;			
	}

}
