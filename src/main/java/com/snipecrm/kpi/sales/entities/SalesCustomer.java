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
@Table(name = "SALES_CUSTOMER")
public class SalesCustomer {
	
	@Id
	@GeneratedValue
	@Column(name = "CUST_ID")
	private Integer custId;
	
	@Column(name = "YEAR")
	private Integer year;
	
	@Column(name = "MONTH")
	private String month;
	
	@Column(name = "NEW_CUSTOMERS_ACQUIRED")
	private Integer newCustomersAcquired;
	
	@Column(name = "PRIOR_CUSTOMERS")
	private Integer priorCustomers;
	
	@Column(name = "CUSTOMER_LOST")
	private Integer customerLost;
	
	@Column(name = "AVG_PURCHASE_VALUE")
	private Float avgPurchaseValue;
	
	@Column(name = "AVG_PURCHASE_FREQ_RATE")
	private Float avgPurchaseFreqRate;
	
	@Column(name = "AVG_CUSTOMER_LIFESPAN")
	private Float avgCustomerLifespan;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;
	
}
