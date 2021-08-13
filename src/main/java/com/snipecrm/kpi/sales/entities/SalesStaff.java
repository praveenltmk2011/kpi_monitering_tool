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
@Table(name = "SALES_STAFF")
public class SalesStaff {

	@Id
	@GeneratedValue
	@Column(name = "STAFF_ID")
	private Integer staffId;
	
	@Column(name = "YEAR")
	private Integer year;
	
	@Column(name = "MONTH")
	private String month;
	
	@Column(name = "SALES_PERSON_NAME")
	private String salesPersonName;
	
	@Column(name = "DESIGNATION")
	private String designation;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "TARGETS")
	private Integer targets;
	
	@Column(name = "ACHIEVEMENTS")
	private Integer achievements;
	
	@Column(name = "DATE")
	private Date date;
	
	@Column(name = "NO_OF_ORDERS")
	private Integer noOfOrders;
	
	@Column(name = "SALES_COST")
	private Float salesCost;
	
	@Column(name = "SALES_PROFIT")
	private Float salesProfit;
	
	@Column(name = "COMMISSION_PAID")
	private Float commissionPaid;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;
	
}
