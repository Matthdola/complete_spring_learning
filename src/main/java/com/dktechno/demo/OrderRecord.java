package com.dktechno.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderRecord(
         String customerName,
         String productName,
         int quantity
) {
}
