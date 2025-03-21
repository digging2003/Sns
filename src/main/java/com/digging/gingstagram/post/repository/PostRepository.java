package com.digging.gingstagram.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digging.gingstagram.post.domain.Post;
import com.digging.gingstagram.user.domain.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
