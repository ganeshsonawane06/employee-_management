package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.User;
import com.employee.entity.UserResponse;
import com.employee.entity.LoginResponse;
import com.employee.repository.UserRepo;
import com.employee.utils.Utils;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	public LoginResponse performLogin(String userName, String password) {
		LoginResponse response = new LoginResponse();

		try {
			User user = userRepo.getUserByEmail(userName);
			if(user != null && user.getPassword().equals(password) && user.getEmail().equals(userName)) {
				response.setMessage("Valid user");
			} else {
				response.setMessage("Invalid user");
				return response;
			}

			response.setUser(user);
		} catch (Exception e) {
			response.setMessage("Invalid user name ! Error:: "+e.getMessage());
		}
		return response;
	}
	
	public UserResponse getUser(long userId) {
		UserResponse response = new UserResponse();
		try {
			User user = userRepo.findById(userId).get();
			response.setUser(user);
			
			return response;
		} catch (Exception e) {
			response.setMessage("Invalid user ID ! Error:: "+e.getMessage());
			return response;
		}
	}
	
	public UserResponse addUser(User user) {
		UserResponse response = new UserResponse();
		try {
			User saved_user = userRepo.save(user);
			
			response.setUser(saved_user);
			response.setMessage(Utils.CONST_SUCCESS);
			
			return response;
		} catch (Exception e) {
			response.setMessage("Please provide valid user details ! Error:: "+e.getMessage());
			return response;
		}
	}
	
	public UserResponse updateUser(User user) {
		UserResponse response = new UserResponse();
		try {
			if (user.getUserId() == 0) {
				response.setMessage("Please provide user ID !");
			} else {
				User saved_user = userRepo.save(user);
				response.setUser(saved_user);
				response.setMessage(Utils.CONST_SUCCESS);
			}
			
			return response;
		} catch (Exception e) {
			response.setMessage("Unable to update user details ! Error:: "+e.getMessage());
			return response;
		}
	}
	
	public UserResponse deleteUser(long userId) {

		UserResponse response = new UserResponse();
		try {
			userRepo.deleteById(userId);
	
			response.setMessage("user having ID "+userId+" deleted successfully.");
			
			return response;
		} catch (Exception e) {
			response.setMessage("Invalid user ID ! Error:: "+e.getMessage());
			return response;
		}
	}
	
	public UserResponse getAllUser() {
		UserResponse response = new UserResponse();
		List<User> userList = (List<User>) userRepo.findAll();
		response.setUsers(userList);
		
		return response;
	}
}
