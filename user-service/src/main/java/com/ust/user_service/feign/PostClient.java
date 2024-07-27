package com.ust.user_service.feign;

import com.ust.user_service.client.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name="post-service",url="http://localhost:9100/post")
public interface PostClient {
    @GetMapping("/getpostbyuser/{userid}")
    List<Post> findPostsByUserid(@PathVariable("userid") Long userid);
}
