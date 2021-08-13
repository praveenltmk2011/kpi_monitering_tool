package com.snipecrm.kpi.sales.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snipecrm.kpi.sales.entities.SalesExpenditure;

@Repository
public interface SalesExpenditureRepository extends JpaRepository<SalesExpenditure, Serializable> {

	public List<SalesExpenditure> findByYear(Integer year);
}
