package com.crm.crm_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.crm_backend.entity.Interaction;

public interface InteractionRepository extends JpaRepository<Interaction, Long> {
}
