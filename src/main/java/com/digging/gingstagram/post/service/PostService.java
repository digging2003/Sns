package com.digging.gingstagram.post.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.digging.gingstagram.comment.domain.Comment;
import com.digging.gingstagram.comment.service.CommentService;
import com.digging.gingstagram.common.FileManager;
import com.digging.gingstagram.post.domain.Post;
import com.digging.gingstagram.post.dto.CardView;
import com.digging.gingstagram.post.repository.PostRepository;
import com.digging.gingstagram.user.domain.User;
import com.digging.gingstagram.user.service.UserService;

import jakarta.persistence.PersistenceException;

@Service
public class PostService {

	private final PostRepository postRepository;
	
	private UserService userService;
	
	private CommentService commentService;
	
	public PostService(PostRepository postRepository, UserService userService, CommentService commentService) {
		this.postRepository = postRepository;
		this.userService = userService;
		this.commentService = commentService;
	}
	
	public boolean addPost(int userId, String contents, MultipartFile imageFile) {
		
		String imagePath = FileManager.saveFile(userId, imageFile);
		
		Post post = Post.builder()
		.userId(userId)
		.contents(contents)
		.imagePath(imagePath)
		.build();
		
		postRepository.save(post);
		
		try {
			postRepository.save(post);
		} catch(PersistenceException e) {
			return false;
		}
		
		return true;
		
		
	}
	
	public List<CardView> getPostList() {
		List<Post> postList = postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		
		List<CardView> cardList = new ArrayList<>();
		
		for(Post post:postList) {
			User user = userService.getUserById(post.getUserId());
			List<Comment> commentList = commentService.getCommentListByPostId(post.getId());
			List<String> commentLoginIdList = commentService.getCommentLoginIdList(commentList);
			
			CardView cardView = CardView.builder()
			.postId(post.getId())
			.contents(post.getContents())
			.imagePath(post.getImagePath())
			.userId(post.getUserId())
			.loginId(user.getLoginId())
			.commentList(commentList)
			.commentLoginIdList(commentLoginIdList)
			.build();
			
			cardList.add(cardView);
		}
		
		return cardList;
		
	}
	
	
	
}
