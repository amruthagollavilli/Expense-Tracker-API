package org.example.expense_tracker_api.repository;

import org.example.expense_tracker_api.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
