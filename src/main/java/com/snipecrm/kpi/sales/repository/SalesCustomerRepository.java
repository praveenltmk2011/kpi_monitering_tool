package com.snipecrm.kpi.sales.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snipecrm.kpi.sales.entities.SalesCustomer;

@Repository
public interface SalesCustomerRepository extends JpaRepository<SalesCustomer, Serializable> {

	public List<SalesCustomer> findByYear(Integer year);
}
