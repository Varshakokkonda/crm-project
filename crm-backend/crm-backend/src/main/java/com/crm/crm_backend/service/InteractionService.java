package com.crm.crm_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.crm_backend.dto.InteractionResponse;
import com.crm.crm_backend.entity.Customer;
import com.crm.crm_backend.entity.Interaction;
import com.crm.crm_backend.repository.CustomerRepository;
import com.crm.crm_backend.repository.InteractionRepository;

@Service
public class InteractionService {

    @Autowired
    private InteractionRepository interactionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<InteractionResponse> getAllInteractions() {
        // Changed: return customerName with each interaction so the existing frontend table can render directly.
        return interactionRepository.findAll().stream().map(this::toResponse).toList();
    }

    public InteractionResponse addInteraction(Interaction interaction) {
        Interaction savedInteraction = interactionRepository.save(interaction);
        return toResponse(savedInteraction);
    }

    public void deleteInteraction(Long id) {
        interactionRepository.deleteById(id);
    }

    private InteractionResponse toResponse(Interaction interaction) {
        InteractionResponse response = new InteractionResponse();
        response.setId(interaction.getId());
        response.setCustomerId(interaction.getCustomerId());
        response.setType(interaction.getType());
        response.setNotes(interaction.getNotes());
        response.setInteractionDate(interaction.getInteractionDate());

        Customer customer = customerRepository.findById(interaction.getCustomerId()).orElse(null);
        response.setCustomerName(customer != null ? customer.getName() : "Unknown Customer");

        return response;
    }
}
