package org.example.expense_tracker_api.service;
import org.example.expense_tracker_api.dto.UserRequest;
import org.example.expense_tracker_api.dto.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    UserResponse AddUser(UserRequest request);

    List<UserResponse> getAllUsers();

}
