package com.digging.gingstagram.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digging.gingstagram.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
