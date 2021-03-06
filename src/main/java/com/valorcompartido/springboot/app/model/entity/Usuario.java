package com.valorcompartido.springboot.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//Entidad
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
		
	@Column(name = "nombre_usuario", nullable = false)
	private String Nombre;
	
	@Column(name = "numeroid_usuario", nullable = false)
	private String numeroId;
	
	@Column(name = "email_usuario")
	private String email;
	
	@Column(name = "id_modulo")
	private Long idmodulo;
	
	@OneToMany(mappedBy ="usuario" )
	List<Modulo> moduloList;
	

	
	
	public Usuario() {
		
	}
	

	public Usuario(Long id, String nombre, String numeroId, String email, Date createAt) {
		super();
		this.id = id;
		Nombre = nombre;
		this.numeroId = numeroId;
		this.email = email;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getNumeroId() {
		return numeroId;
	}

	public void setNumeroId(String numeroId) {
		this.numeroId = numeroId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	
	
	

}
