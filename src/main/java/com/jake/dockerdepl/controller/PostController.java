package com.jake.dockerdepl.controller;

import com.jake.dockerdepl.dto.request.PostCreateRequest;
import com.jake.dockerdepl.dto.request.PostModifyRequest;
import com.jake.dockerdepl.dto.response.PostResponse;
import com.jake.dockerdepl.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @GetMapping("/post")
    public Page<PostResponse> list(Pageable pageable) {
        return postService.list(pageable).map(PostResponse::fromPost);
    }

    @PostMapping("/post")
    public ResponseEntity<?> create(@RequestBody PostCreateRequest request) {
        Integer result = postService.save(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/post/{postId}")
    public ResponseEntity<?> modify(@PathVariable Long postId, @RequestBody PostModifyRequest request) {
        Integer result = postService.modify(postId, request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<?> delete(@PathVariable Long postId) {
        Integer result = postService.delete(postId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
