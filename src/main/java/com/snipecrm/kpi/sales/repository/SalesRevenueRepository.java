package com.snipecrm.kpi.sales.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snipecrm.kpi.sales.entities.SalesRevenue;

@Repository
public interface SalesRevenueRepository extends JpaRepository<SalesRevenue, Serializable> {

	public List<SalesRevenue> findByYear(Integer year);
}
