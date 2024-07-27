package com.ust.comment_service.service;

import com.ust.comment_service.client.FullResponse;
import com.ust.comment_service.client.Like;
import com.ust.comment_service.feign.LikeClient;
import com.ust.comment_service.model.Comment;
import com.ust.comment_service.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService {
    @Autowired
    private CommentRepository repo;

    @Autowired
    private LikeClient client;

    public Comment saveComment(Comment comment) {
        return repo.save(comment);
    }

    public FullResponse findCommentByCommentid(Long commentid) {
        Comment c= repo.findByCommentid(commentid);
        List<Like> list = client.findLikesByCommentid(commentid);
        FullResponse res= new FullResponse();
        res.setCommentid(c.getCommentid());
        res.setDescription(c.getDescription());
        res.setLikescount(c.getLikescount());
        res.setUserid(c.getUserid());
        res.setPostid(c.getPostid());
        res.setLikescount(c.getLikescount());
        res.setLikes(list);
        return res;
    }

    public List<Comment> findCommentsByPostid(Long postid) {
        return repo.findByPostid(postid);
    }
}