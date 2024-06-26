package com.weeklymeal.weeklymeal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.weeklymeal.weeklymeal.dto.UserDto;
import com.weeklymeal.weeklymeal.dto.UserDtoMapper;
import com.weeklymeal.weeklymeal.entity.User;
import com.weeklymeal.weeklymeal.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	//Finds a user via id
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}
	
	//Get all the users from the database
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	//Create a new user 
	//The response will only return username and email for security reasons
	public ResponseEntity<UserDto> createUser(User user){
		//Set the default role and creates the user
		user.setRole(User.ROLE_USER);
		userRepository.save(user);
		UserDto userDto = UserDtoMapper.toUserDTO(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
	}
	
	//Delete a user via id
	public String deleteUser(Long id) {
		Optional<User> user = userRepository.findById(id);
		user.ifPresent(userRepository::delete);
		return "Usuario eliminado";
	}
	
	//Update the user
	public ResponseEntity<User> updateUser(Long id, User newUser){
		
		//Searches the user via id
		Optional<User> optionalUser = userRepository.findById(id);
		
		//If user is found, sets the new values, if not, returns a message
		if(optionalUser.isPresent()) {
			User existingUser = optionalUser.get();
			existingUser.setUserName(newUser.getUserName());
			existingUser.setEmail(newUser.getEmail());
			existingUser.setPassword(newUser.getPassword());
			User updatedUser = userRepository.save(existingUser);
			return ResponseEntity.ok(updatedUser);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
