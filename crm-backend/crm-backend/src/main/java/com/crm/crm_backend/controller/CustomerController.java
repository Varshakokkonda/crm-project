package com.crm.crm_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crm.crm_backend.entity.Customer;
import com.crm.crm_backend.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*") // optional (for frontend connection)
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Get all customers
    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/search")
    public List<Customer> search(@RequestParam String name) {
        // Changed: expose the search endpoint expected by the frontend customer list.
        return customerService.searchCustomersByName(name);
    }

    // Get customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id) {
        return customerService.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add customer
    @PostMapping
    public Customer add(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    // Update customer
    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    // Delete customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
