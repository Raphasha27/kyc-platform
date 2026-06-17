# KYC Platform

[![CI](https://github.com/koketseraphasha/kyc-platform/actions/workflows/ci.yml/badge.svg)](https://github.com/koketseraphasha/kyc-platform/actions/workflows/ci.yml)

Know Your Customer verification platform for banking compliance. Automates identity verification, document collection, and risk categorization.

## Features
- Customer registration
- Identity verification workflow
- Document upload and storage
- Compliance tracking
- Risk categorization
- Audit trail

## Stack
Java 21, Spring Boot, PostgreSQL, Docker

## Quick Start
```bash
docker compose up -d
```

## Deployment & Architecture

This project is designed with cloud-ready principles:

- **Containerized** using Docker for consistent deployment
- **Environment-based configuration** — no hardcoded secrets
- **Modular structure** for independent scaling
- **Stateless design** where applicable
- **Separation of concerns** for maintainability

### Run Locally

`ash
docker-compose up --build
`

---

*Part of the Kirov Dynamics Technology portfolio — backend engineering focused on security, scalability, and system design.*
