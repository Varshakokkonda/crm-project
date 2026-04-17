package com.crm.crm_backend.dto;

public class DashboardStatsResponse {

    private long totalCustomers;
    private long totalLeads;
    private long convertedLeads;
    private long totalInteractions;
    private long newLeads;
    private long contactedLeads;

    public long getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(long totalCustomers) {
        this.totalCustomers = totalCustomers;
    }

    public long getTotalLeads() {
        return totalLeads;
    }

    public void setTotalLeads(long totalLeads) {
        this.totalLeads = totalLeads;
    }

    public long getConvertedLeads() {
        return convertedLeads;
    }

    public void setConvertedLeads(long convertedLeads) {
        this.convertedLeads = convertedLeads;
    }

    public long getTotalInteractions() {
        return totalInteractions;
    }

    public void setTotalInteractions(long totalInteractions) {
        this.totalInteractions = totalInteractions;
    }

    public long getNewLeads() {
        return newLeads;
    }

    public void setNewLeads(long newLeads) {
        this.newLeads = newLeads;
    }

    public long getContactedLeads() {
        return contactedLeads;
    }

    public void setContactedLeads(long contactedLeads) {
        this.contactedLeads = contactedLeads;
    }
}
