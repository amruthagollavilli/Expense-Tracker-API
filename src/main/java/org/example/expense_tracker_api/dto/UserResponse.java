package org.example.expense_tracker_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String name;
    private String email;

    public UserResponse(Long id,String name,String email) {
        this.id =id;
        this.name = name;
        this.email = email;
    }
}
