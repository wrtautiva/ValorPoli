package com.valorcompartido.springboot.app.model.entity;

import com.valorcompartido.springboot.app.model.emuns.Estado;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "sub_categoria", schema = "valorpoli", catalog = "")
public class SubCategoriaEntity {
    private int idSubCategoria;
    private String titulo;
    private String fechaCreacion;
    private Estado estado;
    private int categoriaIdCategoria;
    private Collection<ModuloEntity> modulosByIdSubCategoria;
    private CategoriaEntity categoriaByCategoriaIdCategoria;

    @Id
    @Column(name = "id_subCategoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdSubCategoria() {
        return idSubCategoria;
    }

    public void setIdSubCategoria(int idSubCategoria) {
        this.idSubCategoria = idSubCategoria;
    }

    @Basic
    @Column(name = "titulo", length = 70)
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
    @Column(name = "estado")
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "Categoria_idCategoria",insertable=false, updatable=false)
    public int getCategoriaIdCategoria() {
        return categoriaIdCategoria;
    }

    public void setCategoriaIdCategoria(int categoriaIdCategoria) {
        this.categoriaIdCategoria = categoriaIdCategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubCategoriaEntity that = (SubCategoriaEntity) o;
        return idSubCategoria == that.idSubCategoria &&
                estado == that.estado &&
                categoriaIdCategoria == that.categoriaIdCategoria &&
                Objects.equals(titulo, that.titulo) &&
                Objects.equals(fechaCreacion, that.fechaCreacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubCategoria, titulo, fechaCreacion, estado, categoriaIdCategoria);
    }

    @OneToMany(mappedBy = "subCategoriaBySubCategoriaIdSubCategoria")
    public Collection<ModuloEntity> getModulosByIdSubCategoria() {
        return modulosByIdSubCategoria;
    }

    public void setModulosByIdSubCategoria(Collection<ModuloEntity> modulosByIdSubCategoria) {
        this.modulosByIdSubCategoria = modulosByIdSubCategoria;
    }

    @ManyToOne
    @JoinColumn(name = "Categoria_idCategoria", referencedColumnName = "idCategoria")
    public CategoriaEntity getCategoriaByCategoriaIdCategoria() {
        return categoriaByCategoriaIdCategoria;
    }

    public void setCategoriaByCategoriaIdCategoria(CategoriaEntity categoriaByCategoriaIdCategoria) {
        this.categoriaByCategoriaIdCategoria = categoriaByCategoriaIdCategoria;
    }
}
