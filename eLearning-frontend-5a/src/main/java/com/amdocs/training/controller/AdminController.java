package com.amdocs.training.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.amdocs.training.dao.AdminDAO;
import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.AdminDAOImpl;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.Admin;
import com.amdocs.training.model.User;

@Controller
public class AdminController {

	AdminDAO adminDAO = new AdminDAOImpl();

	@GetMapping("/admin-list")
	public String usersPage(Model model) {

		List<Admin> list = adminDAO.findAll();
		model.addAttribute("list", list);
		return "admins";
	}

	@GetMapping("/add-admin")
	public String addUserForm(Model model) {
		model.addAttribute("admin", new Admin());
		return "add-admin";
	}

	@PostMapping("/register-admin")
	public String addUser(@ModelAttribute("admin") Admin admin) {
		adminDAO.addAdmin(admin);
		return "redirect:/admin-list";
	}

//	@GetMapping("/delete-user/{id}")
//	public String deleteUser(@PathVariable("id") Long id) {
//		userDAO.deleteUser(id);
//		return "redirect:/user-list";
//	}
//
//	@GetMapping("/update-user/{id}")
//	public String updateUserForm(@PathVariable("id") Long id, Model model) {
//		User user = userDAO.getUserById(id);
//		model.addAttribute("user", user);
//		return "update-user";
//	}
//
//	@PostMapping("/update-user")
//	public String updateUser(@ModelAttribute("user") User user) {
//		userDAO.updateUser(user);
//		return "redirect:/user-list";
//	}

}
