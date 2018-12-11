package com.example.world.repositiories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.world.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

}
