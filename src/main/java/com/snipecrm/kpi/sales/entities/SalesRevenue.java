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
@Table(name = "SALES_REVENUE")
public class SalesRevenue {

	@Id
	@GeneratedValue
	@Column(name = "REV_ID")
	private Integer revenueId;
	
	@Column(name = "YEAR")
	private Integer year;
	
	@Column(name = "MONTH")
	private String month;
	
	@Column(name = "CURRENT_PERIOD_SALES")
	private Integer currentPeriodSales;
	
	@Column(name = "PRIOR_PERIOD_SALES")
	private Integer priorPeriodSales;
	
	@Column(name = "SALES_REVENUE")
	private Float salesRevenue;
	
	@Column(name = "SALES_TARGET")
	private Integer salesTarget;
	
	@Column(name = "NO_OF_UNITS_SOLD")
	private Integer noOfUnitsSold;
	
	@Column(name = "COST_PER_UNIT")
	private Float costPerUnit;
	
//	@Column(name = "GROSS_SALES")
//	private Integer grossSales;
//	
//	@Column(name = "NET_SALES")
//	private Integer netSales;
//	
//	@Column(name = "GROSS_PROFIT")
//	private Float grossProfit;
//	
//	@Column(name = "NET_PROFIT")
//	private Float netProfit;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;
	
}
