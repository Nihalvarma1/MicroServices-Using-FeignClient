package com.ust.like_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Likedto {
    public Long likeId;
    public Long userid;
    public Long commentid;
}
