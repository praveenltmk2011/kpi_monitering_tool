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
@Table(name = "SALES_INDIRECT_EXPENSES")
public class SalesIndirectExpenses {
	
	@Id
	@GeneratedValue
	@Column(name = "IND_EXP_ID")
	private Integer indExpId;
	
	@Column(name = "YEAR")
	private Integer year;
	
	@Column(name = "MONTH")
	private String month;
	
	@Column(name = "COST_OF_RETURNS")
	private Float costOfReturns;
	
	@Column(name = "ALLOWANCES")
	private Float allowances;
	
	@Column(name = "DISCOUNTS")
	private Integer discounts;
	
	@Column(name = "OPERATING_EXPENSES")
	private Float operatingExpenses;
	
	@Column(name = "TAXES")
	private Float taxes;
	
	@Column(name = "INTEREST_PAID")
	private Float interestPaid;
	
	@Column(name = "DEPRECIATION")
	private Float depreciation;
	
	@Column(name = "AMORTIZATION")
	private Float amortization;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;

}
