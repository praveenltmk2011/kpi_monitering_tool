package com.snipecrm.kpi.sales.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snipecrm.kpi.sales.entities.SalesIndirectExpenses;

@Repository
public interface SalesIndirectExpensesRepository extends JpaRepository<SalesIndirectExpenses, Serializable> {

	public List<SalesIndirectExpenses> findByYear(Integer year);
}
