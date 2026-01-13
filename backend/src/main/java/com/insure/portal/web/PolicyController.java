package com.insure.portal.web;

import com.insure.portal.model.Policy;
import com.insure.portal.repo.PolicyRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
@RequiredArgsConstructor
public class PolicyController {
    private final PolicyRepository repo;

    @GetMapping
    public List<Policy> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Policy one(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
    @PostConstruct
    public void seed() {
        if (repo.count() == 0) {
            repo.save(Policy.builder().name("Health Shield")
                    .description("Comprehensive health coverage with cashless hospital network.")
                    .premium(8999.0).build());
            repo.save(Policy.builder().name("Term Life Secure")
                    .description("Pure term life plan with high sum assured and low premium.")
                    .premium(4999.0).build());
            repo.save(Policy.builder().name("Motor Protect")
                    .description("Covers own damage and third-party for your vehicle.")
                    .premium(2999.0).build());
        }
    }
}
