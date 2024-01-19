
package ifnti.l3.jee.entities;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@Column(name = "id", insertable = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Basic
	@Column(length = 30, nullable = false, insertable = true, unique = true)
	private String libelle;

	public Role(String id) {
		super();

		this.id = Long.parseLong(id);

	}

	public Role() {
	}

	@Override
	public String toString() {
		return "Role [ libelle=" + libelle + ",id=" + id + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}