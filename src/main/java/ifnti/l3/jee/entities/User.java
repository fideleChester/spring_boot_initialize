
package ifnti.l3.jee.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User  {		
	
	@Id
	@Column(name = "id",insertable=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Basic
	@Column(length = 30, nullable = true,insertable=true)
	private String nom;

	@Basic
	@Column(length = 30, nullable = true,insertable=true)
	private String prenom;
	
	@Basic
	@Column(nullable = false,insertable=true)
	private String email;
	


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Basic
	@Column(length = 30, nullable = false,insertable=true ,unique=true)
	private String user_name;
	
	@Basic
	@Column(length = 30, nullable = false,insertable=true ,unique=true)
	private String password;

	@Basic
	@Column(length = 1, nullable = false,insertable=true)
	private String sexe;
	

	  @ManyToMany
	  @JoinTable(name = "user_role",
	             joinColumns = @JoinColumn(name = "user_id"),
	             inverseJoinColumns = @JoinColumn(name = "role_id"))

	 private List<Role> roles = new ArrayList<>();
	
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public User(String nom, String prenom, String sexe, String email,String password,String user_name) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.email= email;
		this.password = password;
		this.user_name = user_name;
	}
	

	public User() {
		
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


}