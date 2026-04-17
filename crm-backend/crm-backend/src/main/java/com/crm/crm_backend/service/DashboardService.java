package com.crm.crm_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.crm_backend.dto.DashboardStatsResponse;
import com.crm.crm_backend.repository.CustomerRepository;
import com.crm.crm_backend.repository.InteractionRepository;
import com.crm.crm_backend.repository.LeadRepository;

@Service
public class DashboardService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private InteractionRepository interactionRepository;

    public DashboardStatsResponse getStats() {
        DashboardStatsResponse response = new DashboardStatsResponse();

        // Changed: calculate dashboard values directly from the current database records.
        response.setTotalCustomers(customerRepository.count());
        response.setTotalLeads(leadRepository.count());
        response.setConvertedLeads(leadRepository.findByStatus("CONVERTED").size());
        response.setTotalInteractions(interactionRepository.count());
        response.setNewLeads(leadRepository.findByStatus("NEW").size());
        response.setContactedLeads(leadRepository.findByStatus("CONTACTED").size());

        return response;
    }
}
