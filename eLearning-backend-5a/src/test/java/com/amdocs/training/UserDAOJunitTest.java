package com.amdocs.training;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.User;

class UserDAOJunitTest {

	static UserDAO dao = null;

	@BeforeAll
	public static void init() {
		dao = new UserDAOImpl();
	}

	@AfterAll
	public static void destroy() {
		dao = null;
	}

	@Test
	@Order(value = 5)
	void test_get_all_users_success() {
		List<User> users = dao.findAll();
		int expected = 7;
		int actual = users.size();
		assertEquals(expected, actual);

	}

	@Test
	@Order(value = 6)
	void test_get_username_from_all_success() {
		List<User> users = dao.findAll();
		String expected = "krishna";
		String actual = users.get(2).getUsername();
		assertEquals(expected, actual);

	}

	@Test
	@Order(value = 1)
	void test_add_user_success() {
		User user = new User(105L, "krish", "krish#123", "krish@yahoo.co.in", "Mumbai");

		assertTrue(dao.addUser(user));
	}
	@Test
	@Order(value = 2)
	@Disabled
	void test_update_user_success() {
		User user = dao.getUserById(105L);
		user.setPassword("krishna1234");
		
		assertTrue(dao.addUser(user));
	}

	@Test
	@Order(value = 3)
	void test_delete_user_success() {
		assertTrue(dao.deleteUser(105L));
	}

	@Test
	@Order(value = 4)
	void test_get_user_by_id() {

		User user = dao.getUserById(103L);
		assertEquals("Bangalore", user.getAddress());

	}

}
