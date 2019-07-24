package ru.user.controller;
import org.springframework.web.bind.annotation.*;
import ru.user.model.Role;
import ru.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import ru.user.service.UserService;
import java.util.List;

@Controller
public class PersonController {
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView start() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/user/other", method = RequestMethod.GET)
	public ModelAndView startOther() {
		return new ModelAndView("/other");
	}

	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	public ModelAndView allUsers() {
		List<User> users = userService.allUsers();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("users");
		modelAndView.addObject("usersList", users);
		return modelAndView;
	}

	@RequestMapping(value = "/admin/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable("id") Long id) {
		User user = userService.getById(id);
		List<Role> roles = userService.allRoles();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editPage");
		modelAndView.addObject("user", user);
		modelAndView.addObject("roleList", roles);
		return modelAndView;
	}


	@RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute("user") User user) {
		reSetUser(user);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/users");
		userService.edit(user);
		return modelAndView;
	}

	@RequestMapping(value = "/admin/add", method = RequestMethod.GET)
	public ModelAndView addUser() {
		List<Role> roles = userService.allRoles();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addPage");
		modelAndView.addObject("roleList", roles);
		return modelAndView;
	}


	private User reSetUser(User user) {
		for (int i = 0; i < user.getRole().size(); i++) {
			String roletext = user.getRole().get(i).getRole();
			if ("ADMIN".equals(roletext)) {
				user.getRole().get(i).setId(Long.valueOf(1));
			} else if ("USER".equals(roletext)) {
				user.getRole().get(i).setId(Long.valueOf(2));
			}
		}
		return user;
	}

	@RequestMapping(value = "/admin/add", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") User user) {
		reSetUser(user);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/users");
		userService.add(user);
		return modelAndView;
	}

	@RequestMapping(value="/admin/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/users");
		User user = userService.getById(id);
		userService.delete(user);
		return modelAndView;
	}
}
