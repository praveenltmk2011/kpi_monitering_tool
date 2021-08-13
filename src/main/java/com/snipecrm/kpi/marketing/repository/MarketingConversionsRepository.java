package com.snipecrm.kpi.marketing.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snipecrm.kpi.marketing.entities.MarketingConversions;

@Repository
public interface MarketingConversionsRepository extends JpaRepository<MarketingConversions, Serializable>{

	public List<MarketingConversions> findByYear(Integer year);
}
