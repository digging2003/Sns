package com.digging.gingstagram.post;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.digging.gingstagram.comment.domain.Comment;
import com.digging.gingstagram.post.dto.CardView;
import com.digging.gingstagram.post.service.PostService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@Controller
public class PostController {

	private final PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/timeline-view")
	public String timeline(
			HttpSession session
			, Model model) {
		
		int userId = (Integer) session.getAttribute("userId");
		List<CardView> cardList = postService.getPostList(userId);
		
		model.addAttribute("cardList", cardList);
		
		for(CardView card:cardList) {
			for(Comment comment:card.getCommentList()) {
				int commentUserId = comment.getUserId();
			}
		}
		
		return "post/timeline";
	}
	
	@GetMapping("/create-view")
	public String createView() {
		return "post/create";
	}
}

