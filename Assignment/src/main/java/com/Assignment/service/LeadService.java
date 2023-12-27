package com.Assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Assignment.entity.Lead;
import com.Assignment.repository.LeadRepository;

@Service
public class LeadService {

	@Autowired
    private LeadRepository leadRepository;

    public void saveLead(Lead lead) {
        leadRepository.save(lead);
    }

    public boolean isLeadIdExists(Integer leadId) {
        return leadRepository.existsByLeadId(leadId);
    }

    public boolean isEmailExists(String email) {
        return leadRepository.existsByEmail(email);
    }
    
    public List<Lead> getLeadsByMobileNumber(String mobileNumber) {
        return leadRepository.findByMobileNumber(mobileNumber);
    }
}

