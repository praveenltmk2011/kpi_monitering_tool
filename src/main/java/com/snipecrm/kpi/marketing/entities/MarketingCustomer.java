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
@Table(name = "MARKETING_CUSTOMER")
public class MarketingCustomer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUST_ID")
	private Integer custId;
	
	@Column(name = "YEAR")
	private Integer year;
	
	@Column(name = "MONTH")
	private String month;
	
	@Column(name = "TOTAL_NO_OF_VISITORS")
	private Integer totalNoOfVisitors;
	
	@Column(name = "TOTAL_NO_OF_VISITORS_WITHOUT_INTERACTION")
	private Integer totalNoOfVisitorsWithoutInteraction;
	
	@Column(name = "TOTAL_NO_OF_FOLLOWERS")
	private Integer totalNoOfFollowers;
	
	@Column(name = "TOTAL_NO_OF_LIKES")
	private Integer totalNoOfLikes;
	
	@Column(name = "TOTAL_NO_OF_COMMENTS")
	private Integer totalNoOfComments;
	
	@Column(name = "TOTAL_NO_OF_SHARES")
	private Integer totalNoOfShares;
	
	@Column(name = "TOTAL_NO_OF_CLICKS")
	private Integer totalNoOfClicks;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;
	
}
