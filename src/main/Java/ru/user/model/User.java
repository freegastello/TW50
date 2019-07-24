package ru.user.model;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Transactional
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;
	private String name;
	private String login;
	private String password;
	private boolean enabled;
	@ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="role_id")
	)
	private List<Role> role = new ArrayList<>();

	public User() {}

	public User(String name, String login, String password, List<Role> role, boolean enabled) {
		this.name = name;
		this.login = login;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}

	public User(Long id, String name, String login, String password, List<Role> role, boolean enabled) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}

	public boolean isEnabled() {return enabled;}

	public void setEnabled(boolean enabled) {this.enabled = enabled;}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;
		User user = (User) o;
		return isEnabled() == user.isEnabled() &&
				Objects.equals(getId(), user.getId()) &&
				Objects.equals(getName(), user.getName()) &&
				Objects.equals(getLogin(), user.getLogin()) &&
				Objects.equals(getPassword(), user.getPassword()) &&
				Objects.equals(getRole(), user.getRole());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getLogin(), getPassword(), isEnabled(), getRole());
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", enabled=" + enabled +
				", role=" + role +
				'}';
	}
}
