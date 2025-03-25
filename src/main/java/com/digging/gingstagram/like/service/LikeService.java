package com.digging.gingstagram.like.service;

import org.springframework.stereotype.Service;

import com.digging.gingstagram.like.domain.Like;
import com.digging.gingstagram.like.repository.LikeRepository;

import jakarta.persistence.PersistenceException;

@Service
public class LikeService {

	private final LikeRepository likeRepository;
	
	public LikeService(LikeRepository likeRepository) {
		this.likeRepository = likeRepository;
	}
	
	
	public boolean addLike(int postId, int userId) {
		
		Like like = Like.builder()
		.postId(postId)
		.userId(userId)
		.build();
		
		likeRepository.save(like);
		
		try {
			likeRepository.save(like);
		} catch(PersistenceException e) {
			return false;
		}
		
		return true;
	}
	
	public boolean deleteLike(int postId, int userId) {
		
		Like like = likeRepository.findByPostIdAndUserId(postId, userId);
		if (like != null) {
			likeRepository.delete(like);
			return true;
		}
		return false;
	}
	
	public boolean isLike(int postId, int userId) {
		Like like = likeRepository.findByPostIdAndUserId(postId, userId);
		if (like != null) {
			return true;
		}
		return false;
	}
	
	public int likeCount(int postId) {
		return likeRepository.countByPostId(postId);
	}
	
}
