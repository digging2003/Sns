package com.digging.gingstagram.like;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digging.gingstagram.like.service.LikeService;

import jakarta.servlet.http.HttpSession;

@RestController
public class LikeRestController {

	private final LikeService likeService;
	
	public LikeRestController(LikeService likeService) {
		this.likeService = likeService;
	}
	
	@PostMapping("/post/like")
	public Map<String, String> like(
			@RequestParam int postId
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		if(likeService.isLike(postId, userId)) { // 좋아요가 되어있을때 delete
			Map<String, String> resultMap = new HashMap<>();
			if(likeService.deleteLike(postId, userId)) {
				resultMap.put("result", "success");
			} else {
				resultMap.put("result", "fail");
			}
			
			return resultMap;
			
		} else { // 좋아요 없을때 add
			Map<String, String> resultMap = new HashMap<>();
			if(likeService.addLike(postId, userId)) {
				resultMap.put("result", "success");
			} else {
				resultMap.put("result", "fail");
			}
			
			return resultMap;
		}
		

		
	}
}
