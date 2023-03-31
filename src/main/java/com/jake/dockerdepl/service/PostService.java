package com.jake.dockerdepl.service;

import com.jake.dockerdepl.domain.PostEntity;
import com.jake.dockerdepl.dto.Post;
import com.jake.dockerdepl.dto.request.PostCreateRequest;
import com.jake.dockerdepl.dto.request.PostModifyRequest;
import com.jake.dockerdepl.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public Page<Post> list(Pageable pageable) {
        return postRepository.findAll(pageable).map(Post::fromEntity);
    }

    @Transactional
    public Integer save(PostCreateRequest request) {
        postRepository.save(PostEntity.of(request.getTitle(), request.getBody()));
        return 1;
    }

    @Transactional
    public Integer modify(Long postId, PostModifyRequest request) {
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("게시글없음 id: " + postId));
        postEntity.setTitle(request.getTitle());
        postEntity.setBody(request.getBody());
        return 1;
    }

    @Transactional
    public Integer delete(Long postId) {
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("게시글없음 id: " + postId));
        postRepository.deleteById(postEntity.getId());
        return 1;
    }
}
