package com.digging.gingstagram.comment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.digging.gingstagram.comment.domain.Comment;
import com.digging.gingstagram.comment.repository.CommentRepository;
import com.digging.gingstagram.post.domain.Post;
import com.digging.gingstagram.post.dto.CardView;
import com.digging.gingstagram.user.domain.User;

import jakarta.persistence.PersistenceException;

@Service
public class CommentService {

	private final CommentRepository commentRepository;
	
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	// 댓글 추가 기능
	public boolean addComment(int userId, int postId, String contents) {
		
		Comment comment = Comment.builder()
				.userId(userId)
				.postId(postId)
				.contents(contents)
				.build();

		
		commentRepository.save(comment);
		
		try {
			commentRepository.save(comment);
		} catch(PersistenceException e) {
			return false;
		}
		
		return true;
	}
	
	// postId로 댓글 조회 기능
	public List<Comment> getCommentListByPostId(int postId) {
		return commentRepository.findByPostId(postId);
	}
	

}
