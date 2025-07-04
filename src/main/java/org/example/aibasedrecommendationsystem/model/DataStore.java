package org.example.ai.recommendation.model;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

@Component
public class DataStore {
    // user → (item → rating)
    private final Map<Long, Map<Long, Double>> ratings = new HashMap<>();

    public Map<Long, Map<Long, Double>> getRatings() {
        return ratings;
    }

    @PostConstruct
    void loadCsv() throws Exception {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(
                                getClass().getClassLoader().getResourceAsStream("ratings.csv"))))) {

            br.lines().skip(1).forEach(line -> {
                String[] p = line.split(",");
                long u = Long.parseLong(p[0]);
                long i = Long.parseLong(p[1]);
                double r = Double.parseDouble(p[2]);
                ratings.computeIfAbsent(u, k -> new HashMap<>()).put(i, r);
            });
        }
    }
}
