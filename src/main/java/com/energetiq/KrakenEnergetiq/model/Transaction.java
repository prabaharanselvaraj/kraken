package com.energetiq.KrakenEnergetiq.model;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="trxn_id")
    private Long trxnId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_received")
    private Date dateReceived;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="transaction_date")
    private Date transactionDate;

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    @JsonBackReference
    private Invoice invoice;

    @Column(name="invoice_number", nullable = false)
    private Long invoiceNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="billing_period_start")
    private Date billingPeriodStart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="billing_period_end")
    private Date billingPeriodEnd;

    @Column(name="net_transaction_amount", nullable = false)
    private BigDecimal netTransactionAmount;

    @Column(name="gst_amount", nullable = false)
    private BigDecimal gstAmount;

	public Long getTrxnId() {
		return trxnId;
	}

	public void setTrxnId(Long trxnId) {
		this.trxnId = trxnId;
	}

	public Date getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Long getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(Long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getBillingPeriodStart() {
		return billingPeriodStart;
	}

	public void setBillingPeriodStart(Date billingPeriodStart) {
		this.billingPeriodStart = billingPeriodStart;
	}

	public Date getBillingPeriodEnd() {
		return billingPeriodEnd;
	}

	public void setBillingPeriodEnd(Date billingPeriodEnd) {
		this.billingPeriodEnd = billingPeriodEnd;
	}

	public BigDecimal getNetTransactionAmount() {
		return netTransactionAmount;
	}

	public void setNetTransactionAmount(BigDecimal netTransactionAmount) {
		this.netTransactionAmount = netTransactionAmount;
	}

	public BigDecimal getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(BigDecimal gstAmount) {
		this.gstAmount = gstAmount;
	}

	@Override
	public String toString() {
		return "Transaction [trxnId=" + trxnId + ", dateReceived=" + dateReceived + ", transactionDate="
				+ transactionDate + ", invoice=" + invoice + ", invoiceNumber=" + invoiceNumber
				+ ", billingPeriodStart=" + billingPeriodStart + ", billingPeriodEnd=" + billingPeriodEnd
				+ ", netTransactionAmount=" + netTransactionAmount + ", gstAmount=" + gstAmount + "]";
	}
    
}
