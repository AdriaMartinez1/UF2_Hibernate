package castellet.dam.m12.uf2.hibernate;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Clase Sports generada por hbm2java.
 */
@Entity(name = "sports")
@Table(name = "sports")
public class Sports implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod", unique = true, nullable = false, length = 5)
	private String cod; 

	@Column(name = "name", length = 60)
	private String name; 

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sport")
	private Set<Athletes> athletes = new HashSet<>(0);

	
	public Sports() {
	}

	
	public Sports(String cod) {
		this.cod = cod;
	}

	
	public Sports(String cod, String name) {
		this.cod = cod;
		this.name = name;
	}

	
	public String getCod() {
		return cod; 
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Set<Athletes> getAthletes() {
		return this.athletes;
	}

	public void setAthletes(Set<Athletes> athletes) {
		this.athletes = athletes;
	}
}
