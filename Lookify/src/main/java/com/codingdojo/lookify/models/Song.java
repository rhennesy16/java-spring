package com.codingdojo.lookify.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="songs")
public class Song {
	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Size(min = 5, max = 200)
		private String title;
		@Size(min = 5, max = 200)
		private String artist;
		@Max(10)
		private Integer rating;
		@Column(updatable=false)
		private Date createdAt;
		private Date updatedAt;
			
		public Song(String title, String artist, int rating) {
			this.title = title;
			this.artist = artist;
			this.rating = rating;
		}

		public Song() {
		
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getArtist() {
			return artist;
		}

		public void setArtist(String artist) {
			this.artist = artist;
		}

		public Integer getRating() {
			return rating;
		}

		public void setRating(Integer rating) {
			this.rating = rating;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		
		@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }	
}
