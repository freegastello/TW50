package ru.user.dao;
import ru.user.model.Role;
import ru.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	@Override
	public List<User> allUsers() {
		return entityManager.createQuery("from User ORDER BY user_id ASC").getResultList();
	}

	@Override
	public User getById(Long id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public List<Role> allRoles() {
		return entityManager.createQuery("from Role").getResultList();
	}

	@Override
	public void delete(User user) {
		entityManager.remove(entityManager.contains(user)? user : entityManager.merge(user));
	}

	@Override
	public void add(User user) {
		entityManager.persist(user);
	}

	@Override
	public void edit(User user) {
		entityManager.persist(entityManager.contains(user)? user : entityManager.merge(user));
	}
}
