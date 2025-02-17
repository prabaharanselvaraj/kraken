package com.energetiq.KrakenEnergetiq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.energetiq.KrakenEnergetiq.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
	
}