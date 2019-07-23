package ru.user.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Transactional
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private Long id;
	@Column(name = "role")
	private String role;

	public Role() {}

	public Role(String role) {
		this.role = role;
	}

	public Role(Long id, String role) {
		this.id = id;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Role)) return false;
		Role role1 = (Role) o;
		return getId() == role1.getId() &&
				Objects.equals(getRole(), role1.getRole());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getRole());
	}

	@Override
	public String toString() {
		return "Role{" +
				"id=" + id +
				", role='" + role + '\'' +
				'}';
	}
}















//package ru.user.model;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import javax.persistence.*;
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Objects;
//
////@Data
////@Builder
////@AllArgsConstructor
////@NoArgsConstructor
//@Entity
//@Transactional
//@Table(name = "roles")
//public class Role {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "role_id")
//	private Long id;
//	@Column(name = "role")
//	private String role;
//
//	public Role() {}
//
//	public Role(String role) {
//		this.role = role;
//	}
//
//	public Role(Long id, String role) {
//		this.id = id;
//		this.role = role;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}
//
//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (!(o instanceof Role)) return false;
//		Role role1 = (Role) o;
//		return getId() == role1.getId() &&
//				Objects.equals(getRole(), role1.getRole());
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(getId(), getRole());
//	}
//
//	@Override
//	public String toString() {
//		return "Role{" +
//				"id=" + id +
//				", role='" + role + '\'' +
//				'}';
//	}
//}