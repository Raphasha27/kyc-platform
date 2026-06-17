package com.banking.kycplatform.controller;

import com.banking.kycplatform.model.*;
import com.banking.kycplatform.service.KycService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class KycController {
    private final KycService service;

    public KycController(KycService service) { this.service = service; }

    @PostMapping("/customers")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Map<String, String> req) {
        return ResponseEntity.ok(service.registerCustomer(
            req.get("firstName"), req.get("lastName"), req.get("email"),
            req.get("phone"), req.get("country")));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers(@RequestParam(required = false) String status) {
        return ResponseEntity.ok(service.getCustomers(status));
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String id) {
        return ResponseEntity.ok(service.getCustomer(id));
    }

    @PostMapping("/documents")
    public ResponseEntity<IdentityDocument> uploadDocument(@RequestBody Map<String, String> req) {
        return ResponseEntity.ok(service.uploadDocument(
            req.get("customerId"), req.get("documentType"),
            req.get("documentNumber"), req.get("issuingCountry")));
    }

    @GetMapping("/customers/{id}/documents")
    public ResponseEntity<List<IdentityDocument>> getDocuments(@PathVariable String id) {
        return ResponseEntity.ok(service.getDocuments(id));
    }

    @PostMapping("/documents/{id}/verify")
    public ResponseEntity<IdentityDocument> verifyDocument(@PathVariable String id) {
        return ResponseEntity.ok(service.verifyDocument(id));
    }

    @PostMapping("/customers/{id}/verify")
    public ResponseEntity<Customer> verifyCustomer(@PathVariable String id) {
        return ResponseEntity.ok(service.verifyCustomer(id));
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        return ResponseEntity.ok(Map.of("status", "UP", "service", "kyc-platform"));
    }
}
