package com.ust.comment_service.repository;

import com.ust.comment_service.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    Comment findByCommentid(Long commentid);

    List<Comment> findByPostid(Long postid);
}
