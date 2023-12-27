package com.Assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Assignment.entity.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {
    boolean existsByLeadId(Integer leadId);
    boolean existsByEmail(String email);
    List<Lead> findByMobileNumber(String mobileNumber);
}
