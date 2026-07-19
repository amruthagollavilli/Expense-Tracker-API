package org.example.expense_tracker_api.repository;

import org.example.expense_tracker_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
}
