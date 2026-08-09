package org.example.expense_tracker_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class ExpenseResponse {
    private Long id;
    private String title;
    private BigDecimal amount;
    private String category;

    public ExpenseResponse(Long id, String title, BigDecimal amount, String category) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
    }
    public ExpenseResponse() {
    }
}
