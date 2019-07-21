package ru.user.service;
import ru.user.model.Role;
import ru.user.model.User;
import java.util.List;

public interface UserService {
	List<User> allUsers();
	void add(User user);
	void delete(User user);
	void edit(User user);
	User getById(int id);
	List<Role> allRoles();
}
