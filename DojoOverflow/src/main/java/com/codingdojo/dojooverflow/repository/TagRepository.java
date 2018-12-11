package com.codingdojo.dojooverflow.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojooverflow.models.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {
	List<Tag> findAll();
}
