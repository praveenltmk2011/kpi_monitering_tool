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
@Table(name = "MARKETING_TIMESTAMP")
public class MarketingTimestamp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIMESTAMP_ID")
	private Integer timestampId;
	
	@Column(name = "YEAR")
	private Integer year;
	
	@Column(name = "MONTH")
	private String month;
	
	@Column(name = "TOTAL_NO_OF_SESSIONS")
	private Integer totalNoOfSessions;
	
	@Column(name = "TOTAL_TIMETAKEN_FOR_CONVERSION")
	private Long totalTimetakenForConversion;
	
	@Column(name = "TOTAL_MEASURABLE_CLICKS")
	private Integer totalMeasurableClicks;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;
}
