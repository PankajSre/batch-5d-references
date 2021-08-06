package com.amdocs.training.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.User;

@Controller
public class UserController {

	@Autowired
	UserDAO userDAO;

	@GetMapping("/user-list")
	public String usersPage(Model model) {

		List<User> userList = userDAO.findAll();
		model.addAttribute("list", userList);
		return "users";
	}

	@GetMapping("/addUser")
	public String addUserForm(Model model) {
		model.addAttribute("user", new User());
		return "add-user";
	}

	@PostMapping("/register")
	public String addUser(@ModelAttribute("user") User u, HttpServletRequest request) {
		userDAO.addUser(u);

		MultipartFile image = u.getImage();
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		Path path = Paths.get(rootPath + "/resources/images/" + u.getId() + ".png");
		System.out.println("Image Path : " + path);

		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
			} catch (IllegalStateException e) {

				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/user-list";
	}

	@GetMapping("/delete-user/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		userDAO.deleteUser(id);
		return "redirect:/user-list";
	}

	@GetMapping("/update-user/{id}")
	public String updateUserForm(@PathVariable("id") Long id, Model model) {
		User user = userDAO.getUserById(id);
		model.addAttribute("user", user);
		return "update-user";
	}

	@PostMapping("/update-user")
	public String updateUser(@ModelAttribute("user") User user, HttpServletRequest request) {
		userDAO.updateUser(user);
		MultipartFile image = user.getImage();
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		Path path = Paths.get(rootPath + "/resources/images/" + user.getId() + ".png");
		System.out.println("Image Path : " + path);

		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
			} catch (IllegalStateException e) {

				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/user-list";
	}

}
