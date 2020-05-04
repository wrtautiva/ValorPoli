package com.valorcompartido.springboot.app.model.entity;

import com.valorcompartido.springboot.app.model.emuns.Estado;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "categoria", schema = "valorpoli", catalog = "")
public class CategoriaEntity {
    private int idCategoria;
    private String titulo;
    private String fechaCreacion;
    private Estado estado;
    private Collection<SubCategoriaEntity> subCategoriasByIdCategoria;

    @Id
    @Column(name = "idCategoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
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
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Basic
    @Column(name = "estado", nullable = true)
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaEntity that = (CategoriaEntity) o;
        return idCategoria == that.idCategoria &&
                Objects.equals(titulo, that.titulo) &&
                Objects.equals(fechaCreacion, that.fechaCreacion) &&
                Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoria, titulo, fechaCreacion, estado);
    }

    @OneToMany(mappedBy = "categoriaByCategoriaIdCategoria")
    public Collection<SubCategoriaEntity> getSubCategoriasByIdCategoria() {
        return subCategoriasByIdCategoria;
    }

    public void setSubCategoriasByIdCategoria(Collection<SubCategoriaEntity> subCategoriasByIdCategoria) {
        this.subCategoriasByIdCategoria = subCategoriasByIdCategoria;
    }


}
