
package ifnti.l3.jee.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "id", insertable = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Basic
	@Column(nullable = true, insertable = true)
	private String firtname;

	@Basic
	@Column(nullable = false, insertable = true)
	private boolean enabled;

	@Basic
	@Column(nullable = true, insertable = true)
	private String lastname;

	@Basic
	@Column(nullable = false, insertable = true)
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Basic
	@Column(length = 30, nullable = false, insertable = true, unique = true)
	private String username;

	@Basic
	@Column(nullable = false, insertable = true, unique = true)
	private String password;

	@Basic
	@Column(length = 8, nullable = true, insertable = true, unique = true)
	private String contact;

	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))

	private List<Role> roles = new ArrayList<>();

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public User(String lastname, String firtname, String email, String password, String username, String contact) {
		super();
		this.lastname = lastname;
		this.firtname = firtname;
		this.email = email;
		this.contact = contact;
		this.password = password;
		this.username = username;
		this.enabled = false;
	}

	public User() {

	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firtname=" + firtname + ", firtname=" + lastname + ", email=" + email
				+ ", contact=" + contact + ", username=" + username + ", roles=" + roles + "]";
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return this.firtname;
	}

	public void setFirstname(String firtname) {
		this.firtname = firtname;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}