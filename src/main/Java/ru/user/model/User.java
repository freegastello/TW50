package ru.user.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Entity
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Transactional
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	private String name;
	private String login;
	private String password;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="role_id")
	)
	private List<Role> role;

	public User() {}

	public User(String name, String login, String password, List<Role> role) {
		this.name = name;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public User(int id, String name, String login, String password, List<Role> role) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		return getId() == user.getId() &&
				Objects.equals(getName(), user.getName()) &&
				Objects.equals(getLogin(), user.getLogin()) &&
				Objects.equals(getPassword(), user.getPassword()) &&
				Objects.equals(getRole(), user.getRole());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getLogin(), getPassword(), getRole());
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", role=" + role +
				'}';
	}
}
