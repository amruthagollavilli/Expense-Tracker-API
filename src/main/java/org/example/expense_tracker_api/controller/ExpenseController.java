package org.example.expense_tracker_api.controller;

import org.example.expense_tracker_api.entity.Expense;
import org.example.expense_tracker_api.repository.ExpenseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {
    private final ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @PostMapping("/expenses")
    public Expense createExpense(
            @RequestBody Expense expense
    ){
        return expenseRepository.save(expense);
    }

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    @DeleteMapping("/expenses/{id}")
    public void delete(
            @PathVariable Long id
    ){
      expenseRepository.deleteById(id);
    }

    @GetMapping("/expenses/{id}")
    public Expense getexpense(
            @PathVariable Long id
    ){
        return expenseRepository.findById(id).get();
    }

    @PutMapping("/expenses/{id}")
    public Expense updatedExpense(
            @PathVariable Long id,
            @RequestBody Expense updatedExpense
    ){
      Expense expense = expenseRepository.findById(id).get();
        expense.setTitle(updatedExpense.getTitle());
        expense.setAmount(updatedExpense.getAmount());
        expense.setCategory(updatedExpense.getCategory());
        expense.setDate(updatedExpense.getDate());

        return expenseRepository.save(expense);
    }
}
