package com.digging.gingstagram.comment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.digging.gingstagram.comment.domain.Comment;
import com.digging.gingstagram.comment.repository.CommentRepository;
import com.digging.gingstagram.user.domain.User;
import com.digging.gingstagram.user.service.UserService;

import jakarta.persistence.PersistenceException;

@Service
public class CommentService {

	private final CommentRepository commentRepository;
	
	private final UserService userService;
	
	public CommentService(CommentRepository commentRepository, UserService userService) {
		this.commentRepository = commentRepository;
		this.userService = userService;
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
	
	// commentlist 로 loginId 조회 리스트
	
	public List<String> getCommentLoginIdList(List<Comment> commentList) {
		List<String> commentLoginIdList = new ArrayList<>();
		
		for(Comment comment:commentList) {
			int userId = comment.getUserId();
			commentLoginIdList.add(userService.getUserById(userId).getLoginId());
		}
		
		return commentLoginIdList;
	}

}
