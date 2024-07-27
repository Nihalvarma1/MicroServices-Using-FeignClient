package com.ust.comment_service.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Like {
    public Long likeId;
    public Long userid;
    public Long commentid;
}
