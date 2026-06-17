package com.banking.kycplatform.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity @Table(name = "customers")
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String country;
    private String status = "PENDING";
    private LocalDateTime createdAt;

    public Customer() {}
    public Customer(String firstName, String lastName, String email, String phone, String country) {
        this.firstName = firstName; this.lastName = lastName;
        this.email = email; this.phone = phone; this.country = country;
        this.createdAt = LocalDateTime.now();
    }
    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getCountry() { return country; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setStatus(String s) { this.status = s; }
}
