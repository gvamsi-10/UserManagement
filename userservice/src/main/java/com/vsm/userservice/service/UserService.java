package com.vsm.userservice.service;


import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.vsm.userservice.entity.Hotel;
import com.vsm.userservice.entity.Rating;
import com.vsm.userservice.entity.User;
import com.vsm.userservice.exceptions.NoSuchElementException;
import com.vsm.userservice.exceptions.ResourceNotFoundException;
import com.vsm.userservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public User saveUser(User user) {
		return userrepo.save(user);
	}
	
	public List<User> getAllUsers(){
		List<User> users = userrepo.findAll();
//		for(User user:users) {
//			List<Rating> ratingsofUser = restTemplate.getForObject("http://localhost:8083/rating/users/"+ user.getId(), List.class);
//			user.setRating(ratingsofUser);
//		}
		return users;
	}
	
	public User getUser(Long id) {
		User user = userrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with given id: "+ id));
		
//		get the ratings of the above user from RATINGSERVICE
//		http://localhost:8083/rating/users/1
		
		Rating[] ratingsofUser = restTemplate.getForObject("http://localhost:8083/rating/users/"+ user.getId(), Rating[].class);
		List<Rating> ratings = Arrays.asList(ratingsofUser);
		for(Rating rating: ratingsofUser) {
			Hotel hotel = restTemplate.getForObject("http://localhost:8082/api/v1/hotel/2", Hotel.class);
			rating.setHotel(hotel);
		}
		user.setRating(ratings);
		return user;
	}

	public String deleteUser(Long id) {
		User user = userrepo.findById(id).orElseThrow(()-> new NoSuchElementException("user not found with given id: " + id));
		if(user != null) {
			userrepo.deleteById(id);
			return "User Deleted by Id: " + id;
		}
		else {
			return "User with Id " + id + "does not exists";
		}
		
		
	}

	@Transactional
	public User patchUser(Long id, User patchuser) {
		User existinguser = userrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with the given Id: " + id));
		if(existinguser != null) {
			existinguser.setName(patchuser.getName());
			existinguser.setAge(patchuser.getAge());
			existinguser.setCity(patchuser.getCity());
			existinguser.setId(id);
		}
		return patchuser;
	}
}
