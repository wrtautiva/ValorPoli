package com.valorcompartido.springboot.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Modulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
		
	@Column(name = "nombre_modulo", nullable = false)
	private String Nombre;
	
	@Column(name = "tema_modulo", nullable = false)
	private String tema;
	
	@Column(name = "descripcion_modulo")
	private String descripcion;
	
	@Column(name = "titulo_modulo")
	private String titulo;
	

	@Column(name = "imagen_modulo")
	private String imagen;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	
	public Modulo() {
		
	}	

	public Modulo(Long id, String nombre, String tema, String descripcion, String titulo, String imagen,
			Date createAt) {
		super();
		this.id = id;
		Nombre = nombre;
		this.tema = tema;
		this.descripcion = descripcion;
		this.titulo = titulo;
		this.imagen = imagen;
		this.createAt = createAt;
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

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	

}
