package org.example.expense_tracker_api.service;
import org.example.expense_tracker_api.exception.ResourceNotFoundException;
import org.example.expense_tracker_api.dto.ExpenseRequest;
import org.example.expense_tracker_api.dto.ExpenseResponse;
import org.example.expense_tracker_api.entity.Expense;
import org.example.expense_tracker_api.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ExpenseServiceImpl implements ExpenseService{
    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public ExpenseResponse addExpense(ExpenseRequest request) {
       Expense expense = new Expense();
       expense.setTitle(request.getTitle());
       expense.setAmount(request.getAmount());
       expense.setCategory(request.getCategory());
       Expense savedExpense = expenseRepository.save(expense);
       return new ExpenseResponse(
             savedExpense.getId(),
               savedExpense.getTitle(),
             savedExpense.getAmount(),
               savedExpense.getCategory()
       );
    }

    @Override
    public List<ExpenseResponse> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        List<ExpenseResponse> responses= new ArrayList<>();
        for(Expense expense : expenses){
              ExpenseResponse response = new ExpenseResponse(
                      expense.getId(),
                      expense.getTitle(),
                      expense.getAmount(),
                      expense.getCategory()
              );
              responses.add(response);
        }
        return responses;
    }

    @Override
    public ExpenseResponse getExpenseById(Long id) {
        Optional<Expense> expenseRepositoryById = expenseRepository.findById(id);
        Expense actualExpense = expenseRepositoryById.orElseThrow(
                () -> new ResourceNotFoundException("Expense not found")
        );
        return new ExpenseResponse(
                actualExpense.getId(),
                actualExpense.getTitle(),
                actualExpense.getAmount(),
                actualExpense.getCategory()
        );
    }

    @Override
    public ExpenseResponse updateExpense(Long id, ExpenseRequest request) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found"));

        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());

        Expense savedExpense = expenseRepository.save(expense);

        return new ExpenseResponse(
                savedExpense.getId(),
                savedExpense.getTitle(),
                savedExpense.getAmount(),
                savedExpense.getCategory()
        );
    }

    @Override
    public void deleteExpense(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        expenseRepository.delete(expense);
    }
}