package com.crm.crm_backend.controller;

import com.crm.crm_backend.entity.Lead;
import com.crm.crm_backend.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/leads")
@CrossOrigin(origins = "http://localhost:3000")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @GetMapping
    public List<Lead> getAll() {
        return leadService.getAllLeads();
    }

    @PostMapping
    public Lead add(@RequestBody Lead lead) {
        return leadService.addLead(lead);
    }

    @PutMapping("/{id}")
    public Lead update(@PathVariable Long id, @RequestBody Lead lead) {
        // Changed: add lead editing support because the frontend allows editing existing leads.
        return leadService.updateLead(id, lead);
    }

    @GetMapping("/status/{status}")
    public List<Lead> getByStatus(@PathVariable String status) {
        return leadService.getByStatus(status);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        leadService.deleteLead(id);
    }
}
