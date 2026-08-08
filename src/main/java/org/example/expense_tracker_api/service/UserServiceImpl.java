package org.example.expense_tracker_api.service;

import org.example.expense_tracker_api.dto.UserRequest;
import org.example.expense_tracker_api.dto.UserResponse;
import org.example.expense_tracker_api.entity.User;
import org.example.expense_tracker_api.exception.EmailAlreadyExistsException;
import org.example.expense_tracker_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserResponse AddUser(UserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
       User user = new User();
       user.setName(request.getName());
       user.setEmail(request.getEmail());
       user.setPassword(request.getPassword());
        User savedResponse = userRepository.save(user);
        return new UserResponse(
                savedResponse.getId(),
                savedResponse.getName(),
                savedResponse.getEmail()
        );
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> user = userRepository.findAll();
        List<UserResponse> responses = new ArrayList<>();
        for(User users : user){
            UserResponse response = new UserResponse(
                    users.getId(),
                    users.getName(),
                    users.getEmail());
            responses.add(response);
        }
        return responses;
    }
}
