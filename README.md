<img width="1138" alt="Screenshot 2025-07-04 at 3 09 33 PM" src="https://github.com/user-attachments/assets/dcfbc4e7-fad4-4f5e-b8ee-cb9ba7042a8d" />


# 🧠 AI‑Based Recommendation System Using Apache Mahout and Spring Boot

**COMPANY:** CODTECH IT SOLUTIONS  
**NAME:** Sidhi Grover  
**INTERN ID:** CT06DF949  
**DOMAIN:** Java Programming  
**DURATION:** 6 Weeks  
**MENTOR:** Neela Santosh

---

## 🔷 Project Description

In this project, we have designed and developed an **AI‑based recommendation system** using Java, integrated within a Spring Boot framework, and powered by **Apache Mahout** — a scalable machine learning library. The goal of the system is to recommend items (like products, movies, books, etc.) to users based on their past preferences, using collaborative filtering techniques.

This kind of system is commonly used in modern applications like Netflix, Amazon, or Spotify, where understanding user behavior and suggesting relevant content or products significantly enhances user engagement and satisfaction.

The recommendation system follows a **User‑Based Collaborative Filtering** approach, finding users with similar preferences and recommending items they have liked.

---

## 🔷 Technologies and Libraries Used

- **Java 17**
- **Spring Boot (3.5.3)** – For building the web application and exposing APIs
- **Apache Mahout (0.9)** – For collaborative filtering recommendation logic
- **Maven** – Dependency management and build tool
- **Apache Mahout Core + Integration JARs** – Classes like `GenericUserBasedRecommender`, `PearsonCorrelationSimilarity`, `FileDataModel`
- **CSV dataset** – Sample user‑item interactions
- **Apache Commons** – Utility dependencies for Mahout

---

## 🔷 How It Works – Internal Architecture

**User Interaction:**  
The application receives a user ID through a REST API (e.g., `/recommend/1`) and the number of desired recommendations.

**Data Source:**  
Interactions are stored in `data.csv` in the format:

```csv
userID,itemID,preference
1,101,4.0
1,102,3.5
2,101,4.5
2,103,5.0
...
Mahout Components:

FileDataModel reads the CSV into Mahout’s data structure.

PearsonCorrelationSimilarity computes user similarity.

NearestNUserNeighborhood picks the N closest users.

GenericUserBasedRecommender predicts items to recommend.

Recommendation Logic:
Mahout evaluates items that similar users rate highly but the current user hasn’t seen, and recommends them.

Response:
The REST controller returns a list of recommended item IDs, consumable by any frontend (React, Angular, mobile, CLI).

🔷 Use Cases
E‑Commerce: Suggest products based on shopping patterns of similar customers.

Streaming Platforms: Recommend movies or songs based on the viewing/listening history of like‑minded users.

Educational Platforms: Propose learning resources aligned with peer learner behavior.

🔷 Why Apache Mahout?
Mahout is an established library for collaborative filtering, supporting both memory‑based and model‑based recommenders. Even though it is older, it remains excellent for quick prototyping and educational purposes. Unlike modern big‑data frameworks that require extensive setups, Mahout 0.9 works smoothly with small datasets in plain Java.

🔷 Conclusion
This project demonstrates how machine‑learning principles can be applied in Java‑based enterprise applications using Spring Boot. The system is modular, extensible, and easy to integrate into microservices or full‑stack architectures. By implementing collaborative filtering end‑to‑end, we illustrate how AI‑powered recommendations can be brought into production‑ready environments quickly and effectively.

© 2025 CODTECH IT SOLUTIONS — Internship Project by Sidhi Grover



