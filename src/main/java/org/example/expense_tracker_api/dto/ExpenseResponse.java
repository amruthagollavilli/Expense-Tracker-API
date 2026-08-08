package org.example.expense_tracker_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class ExpenseResponse {
    private Long id;
    private String Title;
    private BigDecimal Amount;
    private String Category;

    public ExpenseResponse(Long id, String title, BigDecimal amount, String category) {
    }
    public ExpenseResponse() {
    }
}
