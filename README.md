# 🧩 TP : Consommation d’une API GraphQL — Queries & Mutations

## 📘 Description du TP

Dans ce TP, nous avons été amenés à **implémenter la logique de consommation d’une API GraphQL**, en ajoutant la prise en charge des **requêtes (queries)** et des **mutations** dans une application Java.

L’objectif principal est de comprendre comment :
- Définir un **schéma GraphQL** décrivant les types, les requêtes et les mutations disponibles.
- Créer les **classes Java** correspondantes qui exécutent la logique métier.
- Intégrer ces composants au sein d’un **endpoint GraphQL** accessible par le client.

---

## 🧱 Structure du projet
src/
├── main/
│ ├── java/
│ │ └── com/example/
│ │ ├── **graphql**/
│ │ │ ├── Endpoint.java
│ │ │ ├── Query.java
│ │ │ └── Mutation.java
│ │ └── ...
│ └── resources/

---

## 📦 Package `graphql`

Ce package contient toute la logique liée à **GraphQL** :

### 🔹 Endpoint.java  
Cette classe représente l’**endpoint GraphQL principal**, chargé de recevoir et traiter les requêtes du client.  
Elle fait le lien entre le client et les classes de résolution (queries et mutations).

### 🔹 Query.java  
Cette classe contient la logique des **requêtes de lecture**.  
Elle permet de récupérer les données à partir de la base de données ou d’autres sources.  
Les méthodes définies ici correspondent aux champs déclarés dans la section `type Query` du schéma GraphQL.

### 🔹 Mutation.java  
Cette classe gère les **opérations de modification** (ajout, mise à jour, suppression, etc.).  
Chaque méthode correspond à un champ dans la section `type Mutation` du schéma GraphQL.

---

## 📂 Package `resources`

Ce package contient le fichier **`schema.graphqls`**, qui définit la **structure de l’API GraphQL**.

### 🧭 Rôle du fichier `schema.graphqls`

Le fichier `schema.graphqls` a pour but de :
- Définir les **types d’objets** manipulés par l’API.
- Décrire les **queries** (lecture des données).
- Décrire les **mutations** (modification des données).
│ └── schema.graphqls
└── test/
