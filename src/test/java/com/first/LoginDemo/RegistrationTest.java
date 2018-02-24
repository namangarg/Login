package com.first.LoginDemo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.FixMethodOrder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.junit.runners.MethodSorters;

import com.registration.config.TestConfig;
import com.registration.model.User;
import com.registration.service.UserService;
import com.registration.service.UserServiceImpl;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegistrationTest {

	@Autowired
	private UserService userService;

	@Test
	public void case00_checkRegisterNewUser() {
		User u = new User();

	}
//
//	@Test
//	public void case01_checkEmptyPassword() {
//		User u = new User();
//		u.setEmail("garnaman01893@gmail.com");
//		u.setFirstname("Naman");
//		u.setLastname("Garg");
//		u.setUsername("Naman123");
//		u.setPhonenumber("9187642789");
//		ArrayList<String> result = userService.save(u);
//
//		Assert.assertEquals("failure", result.get(0));
//		Assert.assertEquals("Password cannot be empty", result.get(1));
//	}
//
//	@Test
//	public void case02_checkEmptyPhoneNumber() {
//		User u = new User();
//		u.setEmail("garnaman01893@gmail.com");
//		u.setFirstname("Naman");
//		u.setLastname("Garg");
//		u.setPassword("123Awe@");
//		u.setUsername("Naman123");
//		ArrayList<String> result = userService.save(u);
//
//		Assert.assertEquals("failure", result.get(0));
//		Assert.assertEquals("Phone Number cannot be empty", result.get(1));
//	}
//
//	@Test
//	public void case03_checkValidPhoneNumber() {
//		User u = new User();
//		u.setEmail("garnaman01893@gmail.com");
//		u.setFirstname("Naman");
//		u.setLastname("Garg");
//		u.setPassword("123Awe@");
//		u.setUsername("Naman123");
//		u.setPhonenumber("+9187642789");
//		ArrayList<String> result = userService.save(u);
//		u.setPhonenumber("+9187642789");
//		Assert.assertEquals("failure", result.get(0));
//		Assert.assertEquals("Phone number should contain numbers and length should be 10", result.get(1));
//	}
//
//	@Test
//	public void case04_checkValidPassword() {
//		User u = new User();
//		u.setEmail("garnaman01893@gmail.com");
//		u.setFirstname("Naman");
//		u.setLastname("Garg");
//		u.setPassword("123we@");
//		u.setUsername("Naman123");
//		u.setPhonenumber("9187642789");
//		ArrayList<String> result = userService.save(u);
//		Assert.assertEquals("passwordfailure", result.get(0));
//	}
//
//	@Test
//	public void case05_checkRegisterDuplicateUser() {
//		User u = new User();
//		u.setEmail("garnaman01893@gmail.com");
//		u.setPassword("123Awe@");
//		u.setFirstname("Naman");
//		u.setLastname("Garg");
//		u.setUsername("Naman123");
//		u.setPhonenumber("9187642789");
//		ArrayList<String> result = userService.save(u);
//
//		Assert.assertEquals("success", result.get(0));
//	}

}
