
package ifnti.l3.jee.entities;



import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role  {
	
	@Id
	@Column(name = "id",insertable=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Basic
	@Column(length = 30, nullable = false,insertable=true)
	private String code;

	@Basic
	@Column(length = 30, nullable = false,insertable=true)
	private String libelle;
	
	
	

	public Role(String code, String libelle) {
		super();
		this.code = code;
		this.libelle = libelle;
	}
	
	public Role(Long id_role) {
		super();
		this.id = id_role;
	}
	
	public Role() {}
	
	

	@Override
	public String toString() {
		return "Role [id=" + id + ", code=" + code + ", libelle=" + libelle + "]";
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}