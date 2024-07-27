package com.ust.post_service.controller;

import com.ust.post_service.client.PostResponse;
import com.ust.post_service.model.Post;
import com.ust.post_service.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService service;

    @PostMapping("/addpost")
    public Post savePost(@RequestBody Post post){
        return service.savePost(post);
    }

//    @GetMapping("/getpost/{id}")
//    public Post getPostById(@PathVariable("postid") Long postid){
//        return service.getPostById(postid);
//    }


    @GetMapping("findcommentsbypostid/{postid}")
    public ResponseEntity<PostResponse> findPostByPostid(@PathVariable("postid") Long postid){
        return ResponseEntity.ok(service.findPostByPostid(postid));
    }

    @GetMapping("/getpostbyuser/{userid}")
    public List<Post> findPostsByUserid(@PathVariable("userid") Long userid){
        return service.findPostsByUserid(userid);
    }
}

/*
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService service;

    @PostMapping("/addcomment")
    public Comment saveComment(@RequestBody Comment comment){
        return service.saveComment(comment);
    }
    @GetMapping("withlikes/{commentid}")
    public ResponseEntity<FullResponse> findCommentByCommentid(@PathVariable("commentid") Long commentid){
        return ResponseEntity.ok(service.findCommentByCommentid(commentid));
    }

}
 */