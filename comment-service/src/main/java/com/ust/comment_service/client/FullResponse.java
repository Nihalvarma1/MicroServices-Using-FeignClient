package com.ust.comment_service.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullResponse {
    public Long commentid;
    public String description;
    public Long likescount;
    public Long userid;
    public Long postid;
    public List<Like> likes;
}
