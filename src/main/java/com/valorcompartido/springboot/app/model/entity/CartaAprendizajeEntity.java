package com.valorcompartido.springboot.app.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "carta_aprendizaje", schema = "valorpoli", catalog = "")
public class CartaAprendizajeEntity {
    private int idCarta;
    private String titulo;
    private Timestamp fechaCreacion;
    private Integer estado;
    private String descripcion;
    private String imagen;
    private int moduloIdModulo;
    private ModuloEntity moduloByModuloIdModulo;
    private Collection<ComentarioEntity> comentariosByIdCarta;

    @Id
    @Column(name = "idCarta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(int idCarta) {
        this.idCarta = idCarta;
    }

    @Basic
    @Column(name = "titulo", nullable = true, length = 70)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "fechaCreacion")
    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Basic
    @Column(name = "estado", nullable = true)
    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "descripcion", nullable = true, length = 100)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "imagen", nullable = true, length = 60)
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Basic
    @Column(name = "Modulo_idModulo",insertable=false, updatable=false)
    public int getModuloIdModulo() {
        return moduloIdModulo;
    }

    public void setModuloIdModulo(int moduloIdModulo) {
        this.moduloIdModulo = moduloIdModulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartaAprendizajeEntity that = (CartaAprendizajeEntity) o;
        return idCarta == that.idCarta &&
                moduloIdModulo == that.moduloIdModulo &&
                Objects.equals(titulo, that.titulo) &&
                Objects.equals(fechaCreacion, that.fechaCreacion) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(imagen, that.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCarta, titulo, fechaCreacion, estado, descripcion, imagen, moduloIdModulo);
    }

    @ManyToOne
    @JoinColumn(name = "Modulo_idModulo", referencedColumnName = "idModulo")
    public ModuloEntity getModuloByModuloIdModulo() {
        return moduloByModuloIdModulo;
    }

    public void setModuloByModuloIdModulo(ModuloEntity moduloByModuloIdModulo) {
        this.moduloByModuloIdModulo = moduloByModuloIdModulo;
    }

    @OneToMany(mappedBy = "cartaAprendizajeByCartaAprendizajeIdCarta")
    public Collection<ComentarioEntity> getComentariosByIdCarta() {
        return comentariosByIdCarta;
    }

    public void setComentariosByIdCarta(Collection<ComentarioEntity> comentariosByIdCarta) {
        this.comentariosByIdCarta = comentariosByIdCarta;
    }
}
