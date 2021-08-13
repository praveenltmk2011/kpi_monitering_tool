package com.snipecrm.kpi.marketing.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snipecrm.kpi.marketing.entities.MarketingCustomer;

@Repository
public interface MarketingCustomerRepository extends JpaRepository<MarketingCustomer, Serializable> {

	public List<MarketingCustomer> findByYear(Integer year);
}
