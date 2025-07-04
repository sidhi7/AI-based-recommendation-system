package org.example.ai.recommendation.service;

import org.example.ai.recommendation.model.DataStore;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class Recommender {
    private final Map<Long, Map<Long, Double>> data;

    public Recommender(DataStore store) {
        this.data = store.getRatings();
    }

    /** Cosine‑similarity between two users’ rating vectors. */
    private double similarity(Map<Long, Double> a, Map<Long, Double> b) {
        double dot = 0, na = 0, nb = 0;
        for (Long item : a.keySet()) {
            if (b.containsKey(item)) {
                dot += a.get(item) * b.get(item);
            }
            na += Math.pow(a.get(item), 2);
        }
        for (double v : b.values()) nb += v * v;
        return (na == 0 || nb == 0) ? 0 : dot / (Math.sqrt(na) * Math.sqrt(nb));
    }

    /** Recommend top‑k unseen items for a user. */
    public List<ItemScore> recommend(long userId, int k) {
        Map<Long, Double> target = data.get(userId);
        if (target == null) return List.of();

        // 1. compute similarity to every other user
        Map<Long, Double> sims = new HashMap<>();
        data.forEach((otherId, ratings) -> {
            if (otherId != userId)
                sims.put(otherId, similarity(target, ratings));
        });

        // 2. weighted score for each unseen item
        Map<Long, Double> scores = new HashMap<>();
        sims.forEach((otherId, sim) -> {
            data.get(otherId).forEach((item, rating) -> {
                if (!target.containsKey(item)) {
                    scores.merge(item, sim * rating, Double::sum);
                }
            });
        });

        // 3. return top‑k
        return scores.entrySet().stream()
                .sorted(Map.Entry.<Long, Double>comparingByValue().reversed())
                .limit(k)
                .map(e -> new ItemScore(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public record ItemScore(long itemId, double score) {}
}
