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
@Table(name = "MARKETING_REVENUE")
public class MarketingRevenue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REVENUE_ID")
	private Integer revenue_id;
	
	@Column(name = "YEAR")
	private Integer year;
	
	@Column(name = "MONTH")
	private String month;
	
	@Column(name = "TOTAL_REV_OF_ORGANIC_CHL")
	private Float totalRevOfOrganicChl;
	
	@Column(name = "TOTAL_REV_OF_SOCIAL_CHL")
	private Float totalRevOfSocialChl;
	
	@Column(name = "TOTAL_REV_OF_DIRECT_CHL")
	private Float totalRevOfDirectChl;
	
	@Column(name = "TOTAL_REV_OF_PAID_CHL")
	private Float totalRevOfPaidChl;
	
	@Column(name = "TOTAL_REV_OF_REFERRAL_CHL")
	private Float totalRevOfReferralChl;
	
	@Column(name = "TOTAL_REV_OF_ALL_CHL")
	private Float totalRevOfAllChl;
	
	@Column(name = "TOTAL_REVENUE")
	private Float totalRevenue;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;
}
