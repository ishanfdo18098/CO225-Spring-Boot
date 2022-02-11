package com.example.CO225SpringBootApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CO225SpringBootApp.model.Post;
import com.example.CO225SpringBootApp.repository.PostRepository;


import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
	

	@Autowired
	PostRepository postRepository;
	
	@PostMapping("/posts")
	public ResponseEntity<Post> createTutorial(@RequestBody Post post) {
		try {
			Post _tutorial = postRepository
					.save(new Post(post.getTitle(), post.getDescription(), post.getAuthor(), post.isPublished()));
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}