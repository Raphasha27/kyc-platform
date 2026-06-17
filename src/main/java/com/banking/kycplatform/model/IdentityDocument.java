package com.banking.kycplatform.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity @Table(name = "identity_documents")
public class IdentityDocument {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String customerId;
    private String documentType;
    private String documentNumber;
    private String issuingCountry;
    private String status = "PENDING";
    private LocalDateTime uploadedAt;
    private LocalDateTime verifiedAt;

    public IdentityDocument() {}
    public IdentityDocument(String customerId, String documentType, String documentNumber, String issuingCountry) {
        this.customerId = customerId; this.documentType = documentType;
        this.documentNumber = documentNumber; this.issuingCountry = issuingCountry;
        this.uploadedAt = LocalDateTime.now();
    }
    public String getId() { return id; }
    public String getCustomerId() { return customerId; }
    public String getDocumentType() { return documentType; }
    public String getDocumentNumber() { return documentNumber; }
    public String getIssuingCountry() { return issuingCountry; }
    public String getStatus() { return status; }
    public LocalDateTime getUploadedAt() { return uploadedAt; }
    public LocalDateTime getVerifiedAt() { return verifiedAt; }
    public void setStatus(String s) { this.status = s; this.verifiedAt = LocalDateTime.now(); }
}
