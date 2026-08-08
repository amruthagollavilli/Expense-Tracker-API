package org.example.expense_tracker_api.dto;


import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Setter
@Getter
public class ExpenseRequest {
  @NotBlank(message = "title is required")
  private String Title;

  @NotNull(message = "amount is required")
  @Positive(message = "Amount must be greater than zero")
  private BigDecimal Amount;

  @NotBlank(message =  "Category is required")
  private String Category;

}
