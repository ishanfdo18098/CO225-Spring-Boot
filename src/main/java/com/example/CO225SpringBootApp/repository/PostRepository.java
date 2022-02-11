package com.example.CO225SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CO225SpringBootApp.model.Post;


public interface PostRepository extends JpaRepository<Post, Long> {
	
	List<Post> findByPublished(boolean published);

}


