package org.example.expense_tracker_api.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.expense_tracker_api.dto.ExpenseResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "expense_data")
public class Expense extends ExpenseResponse {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private BigDecimal amount;
    private String category;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Expense(){

    }
}
