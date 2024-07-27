package com.ust.like_service.repository;

import com.ust.like_service.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepo extends JpaRepository<Like,Long> {
    List<Like> findByCommentid(Long commentid);
}
