package castellet.dam.m12.uf2.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Clase Athletes generada por hbm2java.
 */
@Entity(name = "athletes")
@Table(name = "athletes")
public class Athletes implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod", unique = true, nullable = false, length = 5)
	private String cod; 

	@Column(name = "name", length = 60)
	private String name; 

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_sport", nullable = false) 
	private Sports sport;

	
	public Athletes() {
	}

	
	public Athletes(String cod) {
		this.cod = cod;
	}

	
	public Athletes(String cod, String name) {
		this.cod = cod;
		this.name = name;
	}

	
	public Athletes(String cod, String name, Sports sport) {
		this.cod = cod;
		this.name = name;
		this.sport = sport;
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

	
	public Sports getSport() {
		return sport;
	}

	public void setSport(Sports sport) {
		this.sport = sport;
	}

	
	@Override
	public String toString() {
		return this.name; 
	}
}
