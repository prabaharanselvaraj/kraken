package com.energetiq.KrakenEnergetiq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.energetiq.KrakenEnergetiq.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByInvoiceInvoiceId(Long invoiceId);
}