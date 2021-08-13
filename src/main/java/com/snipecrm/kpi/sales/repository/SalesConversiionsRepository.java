package com.snipecrm.kpi.sales.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snipecrm.kpi.sales.entities.SalesConversions;

@Repository
public interface SalesConversiionsRepository extends JpaRepository<SalesConversions, Serializable> {

	public List<SalesConversions> findByYear(Integer year);
}
