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
@Table(name = "MARKETING_EXPENDITURES")
public class MarketingExpenditures {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EXP_ID")
	private Integer expId;
	
	@Column(name = "YEAR")
	private Integer year;
	
	@Column(name = "MONTH")
	private String month;
	
	@Column(name = "TOTAL_AMT_SPENT")
	private Float totalAmtSpent;
	
	@Column(name = "COST_OF_SP_CAMP_ADWORDS")
	private Float costOfSpCampAdwords;
	
	@Column(name = "COST_OF_SP_CAMP_BANNERS")
	private Float costOfSpCampBanners;
	
	@Column(name = "COST_OF_SP_CAMP_EMAILS")
	private Float costOfSpCampEmails;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;
}
