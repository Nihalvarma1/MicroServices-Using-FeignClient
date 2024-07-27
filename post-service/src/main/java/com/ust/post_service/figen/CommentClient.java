package com.ust.post_service.figen;

import com.ust.post_service.client.Comment;
import com.ust.post_service.client.Like;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="comment-service", url="http://localhost:9099/comment")
public interface CommentClient {
    @GetMapping("getcommentbypost/{postid}")
    List<Comment> findCommentsByPostid(@PathVariable("postid") Long postid);
}


/*
@FeignClient(name="like-service",url="http://localhost:9098/like")
public interface LikeClient {
    @GetMapping("getlikebycomment/{commentid}")
    List<Like> findLikesByCommentid(@PathVariable("commentid") Long commentid);
}
 */