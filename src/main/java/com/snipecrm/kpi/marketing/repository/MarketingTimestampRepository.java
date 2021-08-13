package com.snipecrm.kpi.marketing.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snipecrm.kpi.marketing.entities.MarketingTimestamp;

@Repository
public interface MarketingTimestampRepository extends JpaRepository<MarketingTimestamp, Serializable> {

	public List<MarketingTimestamp> findByYear(Integer year);
}
