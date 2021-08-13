package com.snipecrm.kpi.sales.bindingClasses;

import lombok.Data;

@Data
public class CustomerChurnRate {

	private Integer year;
	private String month;
	private Integer customersAtBeginning;
	private Integer customersLost;
	private Integer revenueLost;
	private Integer customerChurnRate;
	
}
