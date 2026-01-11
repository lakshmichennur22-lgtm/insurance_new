package com.insure.portal.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Purchase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long policyId;
    private String policyName;
    private Double premium;

    private String fullName;
    private String email;
    private Integer age;
    private String nominee;

    private Instant createdAt;
    @PrePersist
    public void prePersist() { if (createdAt == null) createdAt = Instant.now(); }
}
