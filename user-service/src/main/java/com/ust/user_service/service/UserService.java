package com.ust.user_service.service;

import com.ust.user_service.client.Post;
import com.ust.user_service.client.UserResponse;
import com.ust.user_service.dto.Userdto;
import com.ust.user_service.feign.PostClient;
import com.ust.user_service.model.User;
import com.ust.user_service.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;

    @Autowired
    private PostClient client;

    public User addUser(Userdto user) {
        User newUser = User.builder()
                .userid(user.getUserid())
                .username(user.getUsername())
                .email(user.getEmail())
                .age(user.getAge())
                .build();
        return userRepo.save(newUser);
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public UserResponse getByUserid(Long userid) {
        User user = userRepo.findByUserid(userid);
        List<Post> postList = client.findPostsByUserid(userid);
        UserResponse res = new UserResponse();
        res.setUserid(user.getUserid());
        res.setUsername(user.getUsername());
        res.setEmail(user.getEmail());
        res.setAge(user.getAge());
        res.setPostList(postList);
        return res;

    }

}
