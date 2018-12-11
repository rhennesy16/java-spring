package com.example.world.repositiories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.world.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>{
	List<Country>findAll();
	@Query("SELECT cou.name, lang.language, lang.percentage FROM Country cou JOIN cou.languages lang WHERE lang.language = 'Slovene' ORDER BY lang.percentage DESC")
	List<Object[]> query1();
	
	@Query("SELECT cou.name, COUNT(cit.name) FROM Country cou JOIN cou.cities cit GROUP BY cou.name ORDER BY COUNT(cit.name) DESC")
	List<Object[]> query2();

    @Query("SELECT cit.name, cit.population FROM Country cou JOIN cou.cities cit WHERE cou.name = 'Mexico' AND cit.population > 500000 ORDER BY cit.population DESC")
    List<Object[]> query3();

    @Query("SELECT lang.percentage, cou.name, lang.language FROM Country cou JOIN cou.languages lang WHERE lang.percentage > 89 ORDER BY lang.percentage DESC, cou.name ASC")
    List<Object[]> query4(); 
    
	@Query("SELECT cou.name, cou.surface_area, cou.population FROM Country cou WHERE surface_area < 501 AND cou.population > 100000 GROUP BY cou.name")
    List<Object[]> query5();

    @Query("SELECT cou.name,cou.government_form,cou.capital,cou.life_expectancy FROM Country cou WHERE government_form = 'Constitutional Monarchy' AND capital > 200 AND life_expectancy > 75")
    List<Object[]> query6();

}
