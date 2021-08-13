package com.snipecrm.kpi.sales.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "SALES_CONVERSIONS")
public class SalesConversions {
	
	@Id
	@GeneratedValue
	@Column(name = "CONV_ID")
	private Integer conversionId;
	
	@Column(name = "YEAR")
	private Integer year;
	
	@Column(name = "MONTH")
	private String month;
	
	@Column(name = "TOTAL_NO_OF_DEALS")
	private Integer totalNoOfDeals;
	
	@Column(name = "TOTAL_NO_OF_LEADS")
	private Integer totalNoOfLeads;
	
	@Column(name = "TOTAL_NO_OF_OPPORTUNITIES")
	private Integer totalNoOfOpportunities;
	
	@Column(name = "TOTAL_NO_OF_WINS")
	private Integer totalNoOfWins;
	
//	@Column(name = "TOTAL_DEALS_CLOSED")
//	private Integer totalDealsClosed;
	
	@Column(name = "TOTAL_SALES_ACTIVITIES_LOGGED")
	private Integer totalSalesActLogged;
	
	@Column(name = "DAYS_IN_OPPORTUNITY")
	private Integer daysInOpportunity;
	
	@Column(name = "DAYS_IN_PROPOSAL")
	private Integer daysInProposal;
	
	@Column(name = "DAYS_IN_NEGOTIATION")
	private Integer daysInNegotiation;
	
	@Column(name = "DAYS_IN_WINS")
	private Integer daysInWins;
	
	@Column(name = "TOTAL_DAYS_TO_CLOSE_EACH_SALE")
	private Integer totalDaysToCloseEachSale;
	
//	@Column(name = "LEADS_CONVERTED_TO_OPPORTUNITIES")
//	private Integer leadsConvertedToOpportunities;
	
	
//	@Column(name = "OPPORTUNITIES_CONVERTED_TO_WINS")
//	private Integer opportunitiesConvertedToWins;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;

}
