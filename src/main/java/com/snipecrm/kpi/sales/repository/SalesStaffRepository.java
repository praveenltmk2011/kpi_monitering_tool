package com.snipecrm.kpi.sales.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.snipecrm.kpi.sales.entities.SalesStaff;

@Repository
public interface SalesStaffRepository extends JpaRepository<SalesStaff, Serializable> {

	//@Query("SELECT * FROM SALES_STAFF WHERE STATE = 'state'")
	//public List<SalesStaff> findAllSalesStaffByState(String state);
	
//	@Query(value = "SELECT year, month, salesPersonName, designation, state, targets, achievements, date, noOfOrders, salesCost, salesProfit,\r\n"
//			+ " commissionPaid\r\n"
//			+ " from SalesStaff WHERE salesPersonName = 'Ram'", nativeQuery = true)
//	public List<SalesStaff> findAllBySalesPersonName(String salesPersonName);
	
	//public List<SalesStaff> findAllSalesStaffByDate(Date fromDate, Date toDate);
	
	//public List<SalesStaff> findAllSalesStaffByStateAndName(String state, String salesPersonName);
	
	//public List<SalesStaff> findAllSalesStaffByStateAndNameAndDate(String state, String salesPersonName, Date fromDate, Date toDate);
	
	public List<SalesStaff> findBySalesPersonName(String salesPersonName);
	
	public List<SalesStaff> findByState(String state);
	
	
	
	
}
