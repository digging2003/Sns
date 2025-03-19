package com.digging.gingstagram.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digging.gingstagram.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	// WHERE `userId` = #{} ORDER BY `id` DESC;
	public List<Post> findByUserIdOrderByIdDesc(int userId);
}
