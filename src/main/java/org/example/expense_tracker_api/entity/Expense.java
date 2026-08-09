package org.example.expense_tracker_api.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@Entity
@Table(name = "expense_data")
public class Expense{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private BigDecimal amount;
    private String category;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Expense(){

    }
}
