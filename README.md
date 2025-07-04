<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>AI‑Based Recommendation System – Internship Task</title>
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet" />
  <style>
    :root {
      --primary: #0066ff;
      --secondary: #00c39a;
      --bg: #f9fbff;
      --text: #2d3748;
      --card-bg: #ffffff;
      --border: #e2e8f0;
    }

    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
      font-family: "Inter", sans-serif;
      color: var(--text);
      line-height: 1.6;
    }

    body {
      background: var(--bg);
      padding: 2rem;
    }

    header {
      border-bottom: 4px solid var(--primary);
      margin-bottom: 2rem;
    }

    .company-info {
      display: flex;
      flex-wrap: wrap;
      gap: 1rem 2rem;
      padding-bottom: 1rem;
      font-weight: 600;
    }

    .company-info span {
      background: var(--card-bg);
      padding: 0.25rem 0.75rem;
      border: 1px solid var(--border);
      border-radius: 0.375rem;
    }

    h1 {
      font-size: 2rem;
      color: var(--primary);
      margin-bottom: 1rem;
    }

    h2 {
      font-size: 1.375rem;
      color: var(--secondary);
      margin-top: 1.5rem;
      margin-bottom: 0.5rem;
    }

    p {
      margin-bottom: 1rem;
      text-align: justify;
    }

    ul {
      margin-left: 1.5rem;
      margin-bottom: 1rem;
    }

    code {
      background: #edf2f7;
      padding: 0.15rem 0.35rem;
      border-radius: 0.25rem;
      font-size: 0.95rem;
    }

    .section {
      background: var(--card-bg);
      border: 1px solid var(--border);
      border-radius: 0.75rem;
      padding: 1.5rem;
      margin-bottom: 2rem;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.04);
    }

    footer {
      text-align: center;
      font-size: 0.875rem;
      color: #718096;
      margin-top: 2rem;
    }
    @media (min-width: 768px) {
      body {
        padding: 4rem 6rem;
      }
      h1 {
        font-size: 2.5rem;
      }
    }
  </style>
</head>
<body>
  <header>
    <div class="company-info">
      <span>COMPANY: CODTECH IT SOLUTIONS</span>
      <span>NAME: SIDHI GROVER</span>
      <span>INTERN ID: CT06DF949</span>
      <span>DOMAIN: JAVA PROGRAMMING</span>
      <span>DURATION: 6 WEEKS</span>
      <span>MENTOR: NEELA SANTOSH</span>
    </div>
  </header>

  <main>
    <section class="section">
      <h1>🧠 AI‑Based Recommendation System Using Apache Mahout and Spring Boot</h1>
      <h2>🔷 Project Description</h2>
      <p>
        In this project, we have designed and developed an <strong>AI‑based recommendation system</strong> using Java, integrated within a Spring Boot framework, and powered by <strong>Apache Mahout</strong>—a scalable machine learning library. The goal of the system is to recommend items (like products, movies, books, etc.) to users based on their past preferences, using collaborative filtering techniques.
      </p>
      <p>
        This kind of system is commonly used in modern applications like Netflix, Amazon, or Spotify, where understanding user behavior and suggesting relevant content or products significantly enhances user engagement and satisfaction.
      </p>
      <p>
        The recommendation system we’ve built follows a <strong>User‑Based Collaborative Filtering</strong> approach, which means it finds users with similar preferences and recommends items that those similar users have liked but the current user hasn’t tried yet.
      </p>

      <h2>🔷 Technologies and Libraries Used</h2>
      <ul>
        <li>Java 17</li>
        <li>Spring Boot (3.5.3) – For building the web application and exposing APIs</li>
        <li>Apache Mahout (0.9) – For collaborative filtering recommendation logic</li>
        <li>Maven – Dependency management and build tool</li>
        <li>Apache Mahout Core + Integration JARs – Classes like <code>GenericUserBasedRecommender</code>, <code>PearsonCorrelationSimilarity</code>, <code>FileDataModel</code></li>
        <li>CSV dataset – Sample user‑item interactions</li>
        <li>Apache Commons – Utility dependencies for Mahout</li>
      </ul>

      <h2>🔷 How It Works – Internal Architecture</h2>
      <p><strong>User Interaction:</strong> The application receives a user ID through a REST API (e.g., <code>/recommend/1</code>) and the number of desired recommendations.</p>
      <p><strong>Data Source:</strong> Interactions are stored in <code>data.csv</code> in the format:</p>
      <pre><code>userID,itemID,preference
1,101,4.0
1,102,3.5
2,101,4.5
2,103,5.0
...</code></pre>
      <p><strong>Mahout Components:</strong></p>
      <ul>
        <li><code>FileDataModel</code> reads the CSV into Mahout’s data structure.</li>
        <li><code>PearsonCorrelationSimilarity</code> computes user similarity.</li>
        <li><code>NearestNUserNeighborhood</code> picks the <em>N</em> closest users.</li>
        <li><code>GenericUserBasedRecommender</code> predicts items to recommend.</li>
      </ul>
      <p><strong>Recommendation Logic:</strong> Mahout evaluates items similar users rate highly but the current user hasn’t seen, and recommends them.</p>
      <p><strong>Response:</strong> The REST controller returns a list of recommended item IDs that any frontend (React, Angular, mobile, CLI) can consume.</p>

      <h2>🔷 Use Cases</h2>
      <ul>
        <li><strong>E‑Commerce:</strong> Suggest products based on shopping patterns of similar customers.</li>
        <li><strong>Streaming Platforms:</strong> Recommend movies or songs based on the viewing/listening history of like‑minded users.</li>
        <li><strong>Educational Platforms:</strong> Propose learning resources aligned with peer learner behavior.</li>
      </ul>

      <h2>🔷 Why Apache Mahout?</h2>
      <p>
        Mahout is an established library for collaborative filtering, supporting both memory‑based and model‑based recommenders. Even though it is older, it remains excellent for quick prototyping and educational purposes. Unlike modern big‑data frameworks that require extensive setups, Mahout 0.9 works smoothly with small datasets in plain Java.
      </p>

      <h2>🔷 Conclusion</h2>
      <p>
        This project demonstrates how machine‑learning principles can be applied in Java‑based enterprise applications using Spring Boot. The system is modular, extensible, and easy to integrate into microservices or full‑stack architectures. By implementing collaborative filtering end‑to‑end, we illustrate how AI‑powered recommendations can be brought into production‑ready environments quickly and effectively.
      </p>
    </section>
  </main>

  <footer>
    © 2025 CODTECH IT SOLUTIONS – Internship Project by Sidhi Grover
  </footer>
</body>
</html>
