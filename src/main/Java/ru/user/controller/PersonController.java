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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView start() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/users");
		return modelAndView;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView allUsers() {
		List<User> users = userService.allUsers();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("users");
		modelAndView.addObject("usersList", users);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable("id") Long id) {
		User user = userService.getById(id);
		List<Role> roles = userService.allRoles();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editPage");
		modelAndView.addObject("user", user);
		modelAndView.addObject("roleList", roles);
		return modelAndView;
	}


	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute("user") User user) {
		reSetUser(user);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/");
		userService.edit(user);
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
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

//	private ModelAndView saveAddUser(User user) {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("redirect:/");
//		userService.add(user);
//		return modelAndView;
//	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") User user) {
		reSetUser(user);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/");
		userService.add(user);
		return modelAndView;
	}

	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/");
		User user = userService.getById(id);
		userService.delete(user);
		return modelAndView;
	}
}
