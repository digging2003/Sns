package com.digging.gingstagram.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digging.gingstagram.like.domain.Like;

public interface LikeRepository extends JpaRepository<Like, Integer> {

	public Like findByPostIdAndUserId(int postId, int userId);
}
