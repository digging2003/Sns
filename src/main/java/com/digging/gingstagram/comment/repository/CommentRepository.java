package com.digging.gingstagram.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digging.gingstagram.comment.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	public List<Comment> findByPostId(int postId);
	
	public List<Comment> findByUserId(int userId);
}
