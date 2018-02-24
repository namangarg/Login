package com.registration.service;

import java.util.ArrayList;
import java.util.List;
import com.registration.model.User;
import com.registration.model.UserInfo;

public interface UserService {

   ArrayList<String> save(User user);
   UserInfo get(String phonenumber);
   List<User> list();
   String update(long id, User user);
   void delete(long id);
}
