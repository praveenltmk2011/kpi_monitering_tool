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
@Table(name = "SALES_EXPENDITURES")
public class SalesExpenditure {
	
	@Id
	@GeneratedValue
	@Column(name = "EXP_ID")
	private Integer expId;
	
	@Column(name = "YEAR")
	private Integer year;
	
	@Column(name = "MONTH")
	private String month;
	
	@Column(name = "COST_OF_SALES")
	private Float costOfSales;
	
	@Column(name = "COST_OF_MARKETING")
	private Float costOfMarketing;
	
	@Column(name = "COST_OF_GOODS_SERVICES")
	private Float costOfGoodsAndServices;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;

}
