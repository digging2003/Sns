package com.digging.gingstagram.post;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.digging.gingstagram.post.domain.Post;
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
	public String timelineView(
			HttpSession session
			, Model model) {
		
		int userId = (Integer) session.getAttribute("userId");
		List<Post> contentsList = postService.getPostList(userId);
		
		model.addAttribute("postList", postList);
		
		return "post/timeline";
	}
	
	@GetMapping("/create-view")
	public String createView() {
		return "post/create";
	}
}

