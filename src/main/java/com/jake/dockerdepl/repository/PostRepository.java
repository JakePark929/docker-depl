package com.jake.dockerdepl.repository;

import com.jake.dockerdepl.domain.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
