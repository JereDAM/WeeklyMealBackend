package com.weeklymeal.weeklymeal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weeklymeal.weeklymeal.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{

	List<Menu> findMenusByUserId(Long userId);
	
}
