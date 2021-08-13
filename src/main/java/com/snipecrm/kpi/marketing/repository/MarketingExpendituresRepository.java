package com.snipecrm.kpi.marketing.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snipecrm.kpi.marketing.entities.MarketingExpenditures;

@Repository
public interface MarketingExpendituresRepository extends JpaRepository<MarketingExpenditures, Serializable>{

	public List<MarketingExpenditures> findByYear(Integer year);
}
