package com.banking.kycplatform.service;

import com.banking.kycplatform.model.*;
import com.banking.kycplatform.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KycService {
    private final CustomerRepository customerRepo;
    private final IdentityDocumentRepository docRepo;

    public KycService(CustomerRepository cr, IdentityDocumentRepository dr) {
        this.customerRepo = cr; this.docRepo = dr;
    }

    public Customer registerCustomer(String firstName, String lastName, String email, String phone, String country) {
        Customer customer = new Customer(firstName, lastName, email, phone, country);
        return customerRepo.save(customer);
    }

    public IdentityDocument uploadDocument(String customerId, String docType, String docNumber, String issuingCountry) {
        IdentityDocument doc = new IdentityDocument(customerId, docType, docNumber, issuingCountry);
        return docRepo.save(doc);
    }

    public Customer verifyCustomer(String customerId) {
        Customer customer = customerRepo.findById(customerId).orElseThrow();
        List<IdentityDocument> docs = docRepo.findByCustomerId(customerId);
        boolean allVerified = docs.stream().allMatch(d -> "VERIFIED".equals(d.getStatus()));
        customer.setStatus(allVerified ? "VERIFIED" : "PENDING_DOCUMENTS");
        return customerRepo.save(customer);
    }

    public IdentityDocument verifyDocument(String documentId) {
        IdentityDocument doc = docRepo.findById(documentId).orElseThrow();
        doc.setStatus("VERIFIED");
        return docRepo.save(doc);
    }

    public List<Customer> getCustomers(String status) {
        return status != null ? customerRepo.findByStatus(status) : customerRepo.findAll();
    }

    public List<IdentityDocument> getDocuments(String customerId) {
        return docRepo.findByCustomerId(customerId);
    }

    public Customer getCustomer(String id) {
        return customerRepo.findById(id).orElseThrow();
    }
}
