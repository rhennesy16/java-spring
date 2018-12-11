package com.example.ninjagold.models;



	import java.util.Date;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	import javax.validation.constraints.Min;
	import javax.validation.constraints.Size;
	@Entity
	@Table(name="ninja")
	public class ninja {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Size(min = 1, max = 200)
	    private String name;
	    @Size(min = 2, max = 45)
	    private Integer score;
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    
	    public ninja() {
	    }
	    public ninja(String name, Integer score) {
	    	this.name = name;
	    	this.score = score;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getScore() {
			return score;
		}

		public void setScore(Integer score) {
			this.score = score;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
}
