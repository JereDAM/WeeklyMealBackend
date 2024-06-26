package com.weeklymeal.weeklymeal.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "recipe")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "ingredients")
	private String ingredients;
	
	@Column(name = "steps")
	private String steps;
	
	@Column(name = "label")
	private String label;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "weekDay")
	private String weekDay;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

    @ManyToMany(mappedBy = "recipes")
    private Set<Menu> menus;
}
