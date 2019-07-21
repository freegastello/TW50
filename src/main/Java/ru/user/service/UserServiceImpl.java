package ru.user.service;
import ru.user.dao.UserDAO;
import ru.user.model.Role;
import ru.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	@Transactional
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Transactional
	@Override
	public List<User> allUsers() {
		return userDAO.allUsers();
	}

	@Transactional
	@Override
	public void add(User user) {
		userDAO.add(user);
	}

	@Transactional
	@Override
	public void delete(User user) {
		userDAO.delete(user);
	}

	@Transactional
	@Override
	public void edit(User user) {
		userDAO.edit(user);
	}

	@Transactional
	@Override
	public User getById(int id) {
		return userDAO.getById(id);
	}

	@Override
	public List<Role> allRoles() {
		return userDAO.allRoles();
	}
}
