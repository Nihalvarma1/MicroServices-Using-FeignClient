package com.ust.like_service.controller;

import com.ust.like_service.dto.Likedto;
import com.ust.like_service.model.Like;
import com.ust.like_service.service.LikeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {
    @Autowired
    private LikeService likeService;
    @PostMapping("/addlike")
    public ResponseEntity<Like> addProducts(@RequestBody @Valid Likedto like) {
        return new ResponseEntity<>(likeService.addProducts(like), HttpStatus.CREATED);
    }
    @GetMapping("getlikebycomment/{commentid}")
    public List<Like> findLikesByCommentid(@PathVariable("commentid") Long commentid){
        return likeService.findLikesByCommentid(commentid);
    }
}
