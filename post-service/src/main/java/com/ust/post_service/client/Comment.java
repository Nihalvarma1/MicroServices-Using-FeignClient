package com.ust.post_service.client;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    public Long commentid;
    public String description;
    public Long likescount;
    public Long userid;
    public Long postid;
}