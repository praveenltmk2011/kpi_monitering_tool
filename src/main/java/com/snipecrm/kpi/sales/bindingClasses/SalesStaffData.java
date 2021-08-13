package com.snipecrm.kpi.sales.bindingClasses;

import java.util.Date;
import lombok.Data;

@Data
public class SalesStaffData {

	private Integer year;
	private String month;
	private String salesPersonName;
	private String designation;
	private String state;
	private Integer targets;
	private Integer achievements;
	private Date date;
	private Integer noOfOrders;
	private Float totalSalesCost;
	private Float salesProfit;
	private Float commissionPaid;

}
