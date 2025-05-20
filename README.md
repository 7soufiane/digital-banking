# Digital Banking

Digital Banking est une application web complète de gestion bancaire, permettant aux utilisateurs de gérer leurs comptes, consulter leurs transactions, effectuer des virements et suivre l'historique de leurs opérations. Ce projet est conçu avec une architecture moderne Angular (frontend) et Spring Boot (backend).

## Vue globale du projet

L'application Digital Banking vise à offrir une expérience utilisateur fluide et sécurisée pour la gestion des opérations bancaires courantes. Elle s'adresse aussi bien aux clients particuliers qu'aux gestionnaires de comptes.

### Fonctionnalités principales

- **Authentification et gestion des utilisateurs**
- **Consultation des comptes bancaires**
- **Historique des transactions**
- **Virements entre comptes**
- **Gestion des bénéficiaires**
- **Tableau de bord interactif**
- **Sécurité et gestion des accès**

## Vue sur le Backend

Le backend de Digital Banking est développé avec Spring Boot et expose une API REST sécurisée pour la gestion des opérations bancaires. Il gère l'authentification, la logique m��tier, la persistance des données et la sécurité.

### Fonctionnalités principales du Backend

- **Gestion des utilisateurs et authentification (Spring Security, JWT)**
- **Gestion des comptes bancaires (création, consultation, suppression)**
- **Gestion des opérations (virements, dépôts, retraits)**
- **Gestion des bénéficiaires**
- **Historique des transactions**
- **Gestion des rôles et autorisations**
- **Documentation interactive des API via Swagger**

### Architecture du Backend

Le backend suit une architecture en couches :

- **Controller** : Expose les endpoints REST.
- **Service** : Contient la logique métier.
- **Repository** : Accès aux données via Spring Data JPA.
- **Security** : Gestion de l’authentification et des autorisations.
- **DTO/Mapper** : Transfert et transformation des données.

```
backend/
│
├── src/
│   ├── main/
│   │   ├── java/com/example/digitalbanking/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   ├── security/
│   │   │   ├── dto/
│   │   │   └── DigitalBankingApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── ...
│   └── test/
│       └── ...
└── pom.xml
```

### Documentation des API (Swagger)

Le backend expose une documentation interactive des API via Swagger.  
Après avoir démarré le backend, accédez à :

- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

Vous pouvez y explorer et tester toutes les routes REST disponibles.

### Exemples d'API REST

- `POST /api/auth/login` : Authentification utilisateur
- `GET /api/accounts` : Liste des comptes bancaires
- `POST /api/accounts` : Création d’un compte
- `GET /api/accounts/{id}/operations` : Historique des opérations d’un compte
- `POST /api/transfer` : Effectuer un virement


## Technologies utilisées

- **Frontend** : Angular, TypeScript, HTML, CSS
- **Backend** : Spring Boot, Java, Spring Data JPA, Spring Security
- **Base de données** : MySQL ou H2 (pour le développement)
- **Outils** : Maven, Node.js, Angular CLI

## Installation et exécution

### Prérequis

- Node.js et npm
- Angular CLI (`npm install -g @angular/cli`)
- Java 17+
- Maven
- MySQL (ou H2 intégré)

### Lancer le backend

```bash
cd digital-banking
mvn spring-boot:run
```

La documentation Swagger sera disponible sur [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

### Lancer le frontend

```bash
cd frontend
npm install
ng serve
```

Accédez à l'application via [http://localhost:4200](http://localhost:4200).

## Contribution

Les contributions sont les bienvenues ! Merci de soumettre vos pull requests ou d'ouvrir des issues pour toute suggestion ou bug.

