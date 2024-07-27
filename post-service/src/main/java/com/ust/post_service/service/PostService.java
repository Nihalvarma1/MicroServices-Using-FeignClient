package com.ust.post_service.service;


import com.ust.post_service.client.Comment;
import com.ust.post_service.client.Like;
import com.ust.post_service.client.PostResponse;
import com.ust.post_service.figen.CommentClient;
import com.ust.post_service.figen.LikeClient;
import com.ust.post_service.model.Post;
import com.ust.post_service.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepo repo;

    @Autowired
    private LikeClient likeClient;
    
    @Autowired
    private CommentClient commentClient;
    
    public Post savePost(Post post) {
        return repo.save(post);
    }

    public PostResponse findPostByPostid(Long postid) {
        Post post = repo.findByPostid(postid).orElse(null);
        List<Comment> commentList = commentClient.findCommentsByPostid(postid);
        List<List<Like>> likeListByComment = new ArrayList<>();
        for(Comment comment : commentList){
            likeListByComment.add(likeClient.findLikesByCommentid(comment.getCommentid()));
        }

        PostResponse res= new PostResponse();
        res.setPostId(postid);
        res.setPostCaption(post.getPostcaption());
        res.setUserId(post.getUserid());
        res.setCommentList(commentList);
        res.setLikeList(likeListByComment);
        return res;
    }


    public List<Post> findPostsByUserid(Long userid) {
        return repo.findByUserid(userid);
    }
}

