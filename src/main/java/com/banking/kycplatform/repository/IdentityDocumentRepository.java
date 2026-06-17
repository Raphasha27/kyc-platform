package com.banking.kycplatform.repository;

import com.banking.kycplatform.model.IdentityDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IdentityDocumentRepository extends JpaRepository<IdentityDocument, String> {
    List<IdentityDocument> findByCustomerId(String customerId);
    List<IdentityDocument> findByStatus(String status);
}
