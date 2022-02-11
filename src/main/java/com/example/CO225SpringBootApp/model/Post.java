package com.example.CO225SpringBootApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		@Column(name = "title")
		private String title;
		@Column(name = "description")
		private String description;
		@Column(name = "author")
		private String author;
		@Column(name = "published")
		private boolean published;
		
		public Post() {
			
		}
		
		public Post(String title, String description, String author, boolean published) {
			this.title = title;
			this.description = description;
			this.author = author;
			this.published = published;
		}
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public boolean isPublished() {
			return published;
		}
		public void setPublished(boolean published) {
			this.published = published;
		}
		@Override
		public String toString() {
			return "Post [id=" + id + ", title=" + title + ", description=" + description + ", author=" + author
					+ ", published=" + published + "]";
		}
		
		
}
