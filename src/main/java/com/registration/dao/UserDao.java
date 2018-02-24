package com.registration.dao;

import java.util.ArrayList;
import java.util.List;
import com.registration.model.User;
import com.registration.model.UserInfo;

public interface UserDao {

	ArrayList<String> save(User book);

	UserInfo get(String phonenumber);

	List<User> list();

	String update(long id, User book);

	void delete(long id);

}