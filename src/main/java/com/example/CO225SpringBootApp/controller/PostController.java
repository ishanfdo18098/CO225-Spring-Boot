package com.example.CO225SpringBootApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CO225SpringBootApp.model.Post;
import com.example.CO225SpringBootApp.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PostController {
	

	@Autowired
	PostRepository postRepository;
	
	@GetMapping("/posts")
	public List<Post> getAllPost() {
		return	postRepository.findAll();

	}
	
	@PostMapping("/posts")
	public ResponseEntity<Post> createPost(@RequestBody Post post) {
		try {
			Post _tutorial = postRepository
					.save(new Post(post.getTitle(), post.getDescription(), post.getAuthor(), post.isPublished()));
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable("id") long id) {
		Optional<Post> post = postRepository.findById(id);
		 
		if (post.isPresent()) {
			return new ResponseEntity<>(post.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/posts/{id}")
	public ResponseEntity<Post> updateTutorial(@PathVariable("id") long id, @RequestBody Post tutorial) {
		Optional<Post> tutorialData = postRepository.findById(id);
		if (tutorialData.isPresent()) {
			Post _tutorial = tutorialData.get();
			_tutorial.setTitle(tutorial.getTitle());
			_tutorial.setDescription(tutorial.getDescription());
			_tutorial.setAuthor(tutorial.getAuthor());
			_tutorial.setPublished(tutorial.isPublished());
			return new ResponseEntity<>(postRepository.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}