package com.valorcompartido.springboot.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RolHasUsuarioEntityPK implements Serializable {
    private int rolIdRol;
    private int usuarioIdUsuario;

    @Column(name = "Rol_idRol")
    @Id
    public int getRolIdRol() {
        return rolIdRol;
    }

    public void setRolIdRol(int rolIdRol) {
        this.rolIdRol = rolIdRol;
    }

    @Column(name = "Usuario_idUsuario")
    @Id
    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolHasUsuarioEntityPK that = (RolHasUsuarioEntityPK) o;
        return rolIdRol == that.rolIdRol &&
                usuarioIdUsuario == that.usuarioIdUsuario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolIdRol, usuarioIdUsuario);
    }
}
