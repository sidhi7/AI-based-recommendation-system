package org.example.ai.recommendation.web;

import org.example.ai.recommendation.service.Recommender;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecommendationController {
    private final Recommender recommender;

    public RecommendationController(Recommender recommender) {
        this.recommender = recommender;
    }

    @GetMapping("/recommend/{userId}")
    public List<Recommender.ItemScore> recommend(
            @PathVariable long userId,
            @RequestParam(defaultValue = "2") int k) {
        return recommender.recommend(userId, k);
    }
}
