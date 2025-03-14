package com.digging.gingstagram.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
@Controller
public class PostController {

	
	@GetMapping("/timeline-view")
	public String inputJoin() {
		return "post/timeline";
	}
}
