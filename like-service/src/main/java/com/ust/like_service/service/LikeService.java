package com.ust.like_service.service;

import com.netflix.discovery.converters.Auto;
import com.ust.like_service.dto.Likedto;
import com.ust.like_service.model.Like;
import com.ust.like_service.repository.LikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    private LikeRepo likeRepo;

    public Like addProducts(Likedto like) {
        Like like1=Like.builder()
                .likeId(like.getLikeId())
                .userid(like.getUserid())
                .commentid(like.getCommentid())
                .build();
        return likeRepo.save(like1);
    }

    public List<Like> findLikesByCommentid(Long commentid) {
        return likeRepo.findByCommentid(commentid);
    }
}
