package com.digging.gingstagram.post.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.digging.gingstagram.post.domain.Post;
import com.digging.gingstagram.post.repository.PostRepository;

@Service
public class PostService {

	private final PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public Post getPost(int id) {
		
		Optional<Post> optionalPost = postRepository.findById(id);
		
		return optionalPost.orElse(null);
	}
}
