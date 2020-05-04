package com.valorcompartido.springboot.app.model.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "rol", schema = "valorpoli", catalog = "")
public class RolEntity {
    private int idRol;
    private String nombreRol;
    private String descripcion;
    private int estado;
    private Collection<RolHasUsuarioEntity> rolHasUsuariosByIdRol;

    @Id
    @Column(name = "idRol")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    @Basic
    @Column(name = "nombreRol", nullable = true, length = 45)
    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
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
    @Column(name = "estado")
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolEntity rolEntity = (RolEntity) o;
        return idRol == rolEntity.idRol &&
                estado == rolEntity.estado &&
                Objects.equals(nombreRol, rolEntity.nombreRol) &&
                Objects.equals(descripcion, rolEntity.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRol, nombreRol, descripcion, estado);
    }

    @OneToMany(mappedBy = "rolByRolIdRol")
    public Collection<RolHasUsuarioEntity> getRolHasUsuariosByIdRol() {
        return rolHasUsuariosByIdRol;
    }

    public void setRolHasUsuariosByIdRol(Collection<RolHasUsuarioEntity> rolHasUsuariosByIdRol) {
        this.rolHasUsuariosByIdRol = rolHasUsuariosByIdRol;
    }
}
