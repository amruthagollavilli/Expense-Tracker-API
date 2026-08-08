package org.example.expense_tracker_api.controller;

import jakarta.validation.Valid;
import org.example.expense_tracker_api.dto.ExpenseRequest;
import org.example.expense_tracker_api.dto.ExpenseResponse;
import org.example.expense_tracker_api.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {

        this.expenseService = expenseService;
    }

    @PostMapping("/expenses")
    public ExpenseResponse createExpense(
            @Valid @RequestBody ExpenseRequest request
    ){
        return expenseService.addExpense(request);
    }

    @GetMapping("/expenses")
    public List<ExpenseResponse> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @DeleteMapping("/expenses/{id}")
    public void delete(
            @PathVariable Long id
    ){
      expenseService.deleteExpense(id);
    }

    @GetMapping("/expenses/{id}")
    public ExpenseResponse getexpense(
            @PathVariable Long id
    ){
        return expenseService.getExpenseById(id);
    }

    @PutMapping("/expenses/{id}")
    public ExpenseResponse updatedExpense(
            @PathVariable Long id,
            @RequestBody ExpenseRequest request
    ){
      return expenseService.updateExpense(id,request);
    }
}
