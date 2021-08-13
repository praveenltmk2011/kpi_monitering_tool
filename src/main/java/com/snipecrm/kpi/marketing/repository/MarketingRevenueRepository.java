package com.snipecrm.kpi.marketing.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snipecrm.kpi.marketing.entities.MarketingRevenue;

@Repository
public interface MarketingRevenueRepository extends JpaRepository<MarketingRevenue, Serializable>{

	public List<MarketingRevenue> findByYear(Integer year);
}
