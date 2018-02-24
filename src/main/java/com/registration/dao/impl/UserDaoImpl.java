package com.registration.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.registration.dao.UserDao;
import com.registration.model.UserInfo;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import javax.validation.ConstraintViolation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.registration.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static Validator validator;

	/*public ArrayList<String> save(User user) {
		ArrayList<String> list=new ArrayList<String>();
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		Criteria a = criteria.add(Restrictions.like("email", user.getEmail()));
		List<User> b = criteria.list();
		if (b.isEmpty()) {
			Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
			for (ConstraintViolation violation : constraintViolations) {
				if (violation.getPropertyPath() != null) {
					list.add("failure");
					list.add(violation.getMessageTemplate());
					return list;
				}
			}
			if(!isValidPassword(user.getPassword())){
				list.add("passwordfailure");
				StringBuilder sb=new StringBuilder("Password conditions failed..");  
				sb.append("\n");
				sb.append("1.At least one upper case English letter.");
				sb.append("\n");
				sb.append("2.At least one lower case English letter");
				sb.append("\n");
				sb.append("3.At least one digit");
				sb.append("\n");
				sb.append("4.At least one special character");
				sb.append("\n");
				sb.append("5.Minimum Length to be 5");
				list.add(sb.toString());
				return list;
			}
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			sessionFactory.getCurrentSession().save(user);
			list.add("success");
			list.add(Long.toString(user.getId()));
			return list;
		} else {
			list.add("failure");
			list.add("Email should be unique");
			return list;
		}
	}*/

	@Override
	public ArrayList<String> save(User book) {
		return null;
	}

	@Override
	public UserInfo get(String phonenumber) {
		return null;
	}

	public User get(long id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	public List<User> list() {
		// Session session = sessionFactory.getCurrentSession();
		// CriteriaBuilder cb = session.getCriteriaBuilder();
		// CriteriaQuery<User> cq = cb.createQuery(User.class);
		// Root<User> root = cq.from(User.class);
		// cq.select(root);
		// Query<User> query = session.createQuery(cq);
		// return query.getResultList();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("title", "naman"));
		List<User> b = criteria.list();
		return b;
	}

	public String update(long id, User user) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		Criteria a = null; //riteria.add(Restrictions.like("email", user.getEmail()));
		List<User> existingUsers = criteria.list();
		if(existingUsers.isEmpty()){
		User user2 = session.byId(User.class).load(id);
		//user2.setEmail(user.getEmail());
		user2.setPhonenumber(user.getPhonenumber());
		session.flush();
		return "success";
		}
		return "Failed to Update...Email already registered";
		
	}

	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.byId(User.class).load(id);
		session.delete(user);
	}
	
	private boolean isValidPassword(String password){
	    Pattern pattern = null;
	    final Matcher matcher;
	    pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{5,}$");
        matcher = pattern.matcher(password);
        return matcher.matches();

	}

}