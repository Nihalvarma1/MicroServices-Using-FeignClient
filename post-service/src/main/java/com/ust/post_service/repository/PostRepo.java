package com.ust.post_service.repository;

import com.ust.post_service.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepo extends JpaRepository<Post,Long> {
    Optional<Post> findByPostid(Long postid);

    List<Post> findByUserid(Long userid);
}
