package com.snipecrm.kpi.marketing.bindingClasses;

import lombok.Data;

@Data
public class AverageTimeToConversion {

	private Integer year;
	private String month;
	private Long totalTimetakenForConversion;
	private Integer totalNoOfConversion;
	private Long avgTimeToConversion;
	
}
