package com.energetiq.KrakenEnergetiq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.energetiq.KrakenEnergetiq.model.Invoice;
import com.energetiq.KrakenEnergetiq.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@PostMapping
	public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {

		Invoice invoiceResponse = invoiceService.createInvoice(invoice);

		return invoiceResponse.getValidationStatus().equalsIgnoreCase("INVALID") 
			       ? ResponseEntity.badRequest().build() 
			       : ResponseEntity.ok(invoiceResponse);
	}

	@GetMapping
	public ResponseEntity<List<Invoice>> getAllInvoices() {
		return ResponseEntity.ok(invoiceService.getAllInvoices());
	}

	@GetMapping("/{invoiceId}")
	public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long invoiceId) {
		return ResponseEntity.ok(invoiceService.getInvoiceById(invoiceId));
	}

	@GetMapping("/{invoiceId}/status")
	public ResponseEntity<String> getInvoiceStatus(@PathVariable Long invoiceId) {
		return ResponseEntity.ok(invoiceService.getInvoiceStatus(invoiceId));
	}

}
