package com.energetiq.KrakenEnergetiq.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;


@Entity
@Table(name = "invoice")
public class Invoice {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "invoice_id")
	    private Long invoiceId;

	    @Column(name = "invoice_number", nullable = false)
	    private Long invoiceNumber;

	    @Column(name = "gross_amount", nullable = false)
	    private BigDecimal grossAmount;

	    @Column(name = "gst_amount", nullable = false)
	    private Double gstAmount;

	    @Column(name = "net_amount", nullable = false)
	    private Double netAmount;

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "receipt_date", nullable = false)
	    private Date receiptDate;

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "payment_due_date", nullable = false)
	    private Date paymentDueDate;

	    @Column(name = "total_no_trxn", nullable = false)
	    private Integer totalNoTrxn;
	    
	    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
	    @JsonManagedReference
	    private List<Transaction> transactions;
	    
	    @Transient
	    private String validationStatus;

		public Long getInvoiceId() {
			return invoiceId;
		}

		public void setInvoiceId(Long invoiceId) {
			this.invoiceId = invoiceId;
		}

		public Long getInvoiceNumber() {
			return invoiceNumber;
		}

		public void setInvoiceNumber(Long invoiceNumber) {
			this.invoiceNumber = invoiceNumber;
		}

		public BigDecimal getGrossAmount() {
			return grossAmount;
		}

		public void setGrossAmount(BigDecimal grossAmount) {
			this.grossAmount = grossAmount;
		}

		public Double getGstAmount() {
			return gstAmount;
		}

		public void setGstAmount(Double gstAmount) {
			this.gstAmount = gstAmount;
		}

		public Double getNetAmount() {
			return netAmount;
		}

		public void setNetAmount(Double netAmount) {
			this.netAmount = netAmount;
		}

		public Date getReceiptDate() {
			return receiptDate;
		}

		public void setReceiptDate(Date receiptDate) {
			this.receiptDate = receiptDate;
		}

		public Date getPaymentDueDate() {
			return paymentDueDate;
		}

		public void setPaymentDueDate(Date paymentDueDate) {
			this.paymentDueDate = paymentDueDate;
		}

		public Integer getTotalNoTrxn() {
			return totalNoTrxn;
		}

		public void setTotalNoTrxn(Integer totalNoTrxn) {
			this.totalNoTrxn = totalNoTrxn;
		}

		public List<Transaction> getTransactions() {
			return transactions;
		}

		public void setTransactions(List<Transaction> transactions) {
			this.transactions = transactions;
		}

		public String getValidationStatus() {
			return validationStatus;
		}

		public void setValidationStatus(String validationStatus) {
			this.validationStatus = validationStatus;
		}

		@Override
		public String toString() {
			return "Invoice [invoiceId=" + invoiceId + ", invoiceNumber=" + invoiceNumber + ", grossAmount="
					+ grossAmount + ", gstAmount=" + gstAmount + ", netAmount=" + netAmount + ", receiptDate="
					+ receiptDate + ", paymentDueDate=" + paymentDueDate + ", totalNoTrxn=" + totalNoTrxn
					+ ", transactions=" + transactions + ", validationStatus=" + validationStatus + "]";
		}
	    

	    
}
