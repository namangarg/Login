package com.registration.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.notifi.response.TestResponse;
import com.registration.model.User;
import com.registration.model.UserInfo;
import com.registration.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/*---Add new user---*/
	@PostMapping("/user")
	public ResponseEntity<?> save(@RequestBody User user) {
		try {
			ArrayList<String> message = userService.save(user);
			if (message.get(0).equals("success")) {
				return ResponseEntity.ok().body("Successfully registered with the system with ID:" + message.get(1));
			}else if(message.get(0).equals("passwordfailure")){
				return ResponseEntity.ok().body(message.get(1).split("\n"));
			}
			else {
				return ResponseEntity.badRequest().body(message);
			}
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e);
		}
	}

//	/*---Get a user by id---*/
//	@GetMapping("/user/{id}")
//	public ResponseEntity<User> get(@PathVariable("id") long id) {
//		User user = userService.get(id);
//		return ResponseEntity.ok().body(user);
//	}
	

	/*---Get a user by phonenumber---*/
	@GetMapping("/user/{phonenumber}")
	public ResponseEntity<Map<String, String>> get(@PathVariable("phonenumber") String phonenumber ) {
		UserInfo userInfo = userService.get(phonenumber);
		Map<String, String> result = new HashMap<String, String>();
		Gson gson = new Gson();
		if(userInfo!=null){
		String data = gson.toJson(userInfo, UserInfo.class);
		JsonObject a = gson.fromJson(data, JsonObject.class);
		String y = gson.toJson(a);
		//final JsonParser parser = new JsonParser();
		//JsonElement json = parser.parse(data);
		result.put("isExist", "true");
		result.put("userData", y);
		}
		else{
			result.put("isExist", "false");
			result.put("userData", "");
		}
		return ResponseEntity.ok().body(result);
	}

	/*---get all users---*/
	@GetMapping("/user")
	public ResponseEntity<List<User>> list() {
		List<User> users = userService.list();
		return ResponseEntity.ok().body(users);
	}

	/*---Update a user by id---*/
	@PutMapping("/user/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody User user) {
		
		String message = userService.update(id, user);
		if (message.equals("success")){
		return ResponseEntity.ok().body("User has been updated successfully.");
	}
		else{
			return ResponseEntity.badRequest().body(message);
		}
	}

	/*---Delete a user by id---*/
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		userService.delete(id);
		return ResponseEntity.ok().body("User has been deleted successfully.");
	}
}
