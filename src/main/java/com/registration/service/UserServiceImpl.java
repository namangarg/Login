package com.registration.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.registration.dao.UserDao;
import com.registration.model.User;
import com.registration.model.UserInfo;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Throwable.class)
	public ArrayList<String> save(User user) throws RuntimeException {
		try {
			return userDao.save(user);
		} catch (ConstraintViolationException e) {
			throw new RuntimeException(e.getCause());
		}
	}

	public UserInfo get(String phonenumber) {
		return userDao.get(phonenumber);
	}

	public List<User> list() {
		return userDao.list();
	}

	@Transactional
	public String update(long id, User user) {
		return userDao.update(id, user);
	}

	@Transactional
	public void delete(long id) {
		userDao.delete(id);
	}

}
