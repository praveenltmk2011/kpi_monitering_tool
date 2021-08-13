package com.snipecrm.kpi.marketing.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "MARKETING_CONVERSIONS")
public class MarketingConversions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONVERSION_ID")
	private Integer conversionId;
	
	@Column(name = "YEAR")
	private Integer year;
	
	@Column(name = "MONTH")
	private String month;
	
	@Column(name = "TOTAL_NO_OF_CONVERSIONS")
	private Integer totalNoOfConversions;
	
	@Column(name = "TOTAL_NO_OF_LEADS")
	private Integer totalNoOfLeads;
	
	@Column(name = "NUM_OF_ORDER_PLACED")
	private Integer NumOfOrderPlaced;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;
	
}
