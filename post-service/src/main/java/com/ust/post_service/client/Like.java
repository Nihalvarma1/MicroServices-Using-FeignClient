package com.ust.post_service.client;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Like {
    @Id
    public Long likeId;
    public Long userid;
    public Long commentid;
}