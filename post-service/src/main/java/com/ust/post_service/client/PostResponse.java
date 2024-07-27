package com.ust.post_service.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private Long postId;
    private String postCaption;
    private Long userId;
    private List<Comment> commentList;
    private List<List<Like>> likeList;
}
