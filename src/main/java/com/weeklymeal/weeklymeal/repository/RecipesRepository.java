package com.weeklymeal.weeklymeal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weeklymeal.weeklymeal.entity.Recipe;

@Repository
public interface RecipesRepository extends JpaRepository<Recipe, Long>{
	
	List<Recipe> findByUserId(Long userId);

}
