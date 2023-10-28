package web.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.springboot.model.User;
import web.springboot.service.UserService;

import java.util.List;

@Controller
@RequestMapping ("/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping
	public String getAllUsers (Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "users";
	}
	@GetMapping("/new")
	public String addUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);

		return "newUser";
	}

	@PostMapping()
	public String create(@ModelAttribute("user") User user, Model model) {
		userService.addUser(user);
		return "redirect:/users";
	}

	@PostMapping("/edit")
	public String edit (@RequestParam("userId") int id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return  "newUser";
	}

	@PostMapping("/delete")
	public String delete (@RequestParam("userId") int id) {
		userService.delete(id);
		return "redirect:/users";
	}
}
