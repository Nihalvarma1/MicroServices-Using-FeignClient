package com.ust.comment_service.controller;

import com.ust.comment_service.client.FullResponse;
import com.ust.comment_service.model.Comment;
import com.ust.comment_service.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("getcommentbypost/{postid}")
    public List<Comment> findCommentsByPostid(@PathVariable("postid") Long postid){
        return service.findCommentsByPostid(postid);
    }

}


/*

public class CompanyController {
    @Autowired
    private CompanyService service;

    @PostMapping("/addcompany")
    public Minfo saveCompany(@RequestBody Minfo company) {
        return service.saveCompany(company);
    }
    @GetMapping("withproducts/{mcode}")
    public ResponseEntity<Fullresponse> findcompanyByMcode(@PathVariable("mcode") Long mcode){
        return ResponseEntity.ok(service.findcompanyByMcode(mcode));
    }
 */