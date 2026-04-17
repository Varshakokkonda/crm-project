package com.crm.crm_backend.service;

import com.crm.crm_backend.entity.Lead;
import com.crm.crm_backend.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    public Lead addLead(Lead lead) {
        return leadRepository.save(lead);
    }

    public Lead updateLead(Long id, Lead lead) {
        // Changed: preserve the existing row id so edited leads update instead of inserting new rows.
        lead.setId(id);
        return leadRepository.save(lead);
    }

    public List<Lead> getByStatus(String status) {
        return leadRepository.findByStatus(status);
    }

    public void deleteLead(Long id) {
        leadRepository.deleteById(id);
    }
}
