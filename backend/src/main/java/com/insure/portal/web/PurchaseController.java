package com.insure.portal.web;

import com.insure.portal.model.Policy;
import com.insure.portal.model.Purchase;
import com.insure.portal.repo.PolicyRepository;
import com.insure.portal.repo.PurchaseRepository;
import com.insure.portal.web.dto.PurchaseRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseRepository purchases;
    private final PolicyRepository policies;

    @PostMapping("/purchases")
    public Purchase create(@Valid @RequestBody PurchaseRequest req) {
        Policy p = policies.findById(req.policyId()).orElseThrow();
        Purchase entity = Purchase.builder()
                .policyId(p.getId())
                .policyName(p.getName())
                .premium(p.getPremium())
                .fullName(req.fullName())
                .email(req.email())
                .age(req.age())
                .nominee(req.nominee())
                .build();
        return purchases.save(entity);
    }

    @GetMapping("/admin/purchases")
    public List<Purchase> allPurchases() {
        return purchases.findAll();
    }
}
