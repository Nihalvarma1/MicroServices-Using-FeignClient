package com.ust.user_service.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    public Long userid;
    public String username;
    public String email;
    public String age;
    public List<Post> postList;
}
