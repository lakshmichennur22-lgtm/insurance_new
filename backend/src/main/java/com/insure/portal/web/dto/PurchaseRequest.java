package com.insure.portal.web.dto;

import jakarta.validation.constraints.*;

public record PurchaseRequest(
        @NotNull Long policyId,
        @NotBlank String fullName,
        @Email String email,
        @Min(18) @Max(100) Integer age,
        @NotBlank String nominee
) {}
