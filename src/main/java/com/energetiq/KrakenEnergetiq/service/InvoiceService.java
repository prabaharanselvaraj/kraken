package com.energetiq.KrakenEnergetiq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energetiq.KrakenEnergetiq.model.Invoice;
import com.energetiq.KrakenEnergetiq.model.Transaction;
import com.energetiq.KrakenEnergetiq.repository.InvoiceRepository;
import com.energetiq.KrakenEnergetiq.repository.TransactionRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public Invoice createInvoice(Invoice invoice) {
    	
  
    	
    	Invoice savedInvoice = invoiceRepository.save(invoice);
    		
    	  	//Set the Invoice valiation status
        	if(savedInvoice.getInvoiceId()!=null)
        		savedInvoice.setValidationStatus(getInvoiceStatus(savedInvoice.getInvoiceId()));
        	
        	return savedInvoice;
    		
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long invoiceId) {
		return invoiceRepository.findById(invoiceId)
				.orElse(null);
    }

    public String getInvoiceStatus(Long invoiceId) {
       Invoice invoice = getInvoiceById(invoiceId);
        
        if(invoice==null)
        	return "NEW";
        
        List<Transaction> transactions = transactionRepository.findByInvoiceInvoiceId(invoiceId);

        String validationMessage = validateInvoice(invoice, transactions);
        return validationMessage.isEmpty() ? "VALID" : "INVALID: " + validationMessage;
    }

    private String validateInvoice(Invoice invoice, List<Transaction> transactions) {
        StringBuilder validationErrors = new StringBuilder();

        // Check if the total number of transactions matches
        if (transactions.size() != invoice.getTotalNoTrxn()) {
            validationErrors.append("Number of transactions (")
                    .append(transactions.size())
                    .append(") does not match totalNoTrxn (")
                    .append(invoice.getTotalNoTrxn())
                    .append("). ");
        }

        // Calculate total transaction amount
        BigDecimal totalTransactionAmount = transactions.stream()
                .map(txn -> txn.getNetTransactionAmount().add(txn.getGstAmount()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Compare the calculated total transaction amount with the invoice's gross amount
        if (totalTransactionAmount.compareTo(invoice.getGrossAmount()) != 0) {
            validationErrors.append("Transaction total (")
                    .append(totalTransactionAmount)
                    .append(") does not match invoice gross amount (")
                    .append(invoice.getGrossAmount())
                    .append("). ");
        }

        return validationErrors.toString();
    }
}
