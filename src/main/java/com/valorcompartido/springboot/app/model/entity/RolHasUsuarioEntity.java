package com.valorcompartido.springboot.app.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rol_has_usuario", schema = "valorpoli", catalog = "")
@IdClass(RolHasUsuarioEntityPK.class)
public class RolHasUsuarioEntity {
    private int rolIdRol;
    private int usuarioIdUsuario;
    private int moduloIdModulo;
    private RolEntity rolByRolIdRol;
    private UsuarioEntity usuarioByUsuarioIdUsuario;
    private ModuloEntity moduloByModuloIdModulo;

    @Id
    @Column(name = "Rol_idRol",insertable=false, updatable=false)
    public int getRolIdRol() {
        return rolIdRol;
    }

    public void setRolIdRol(int rolIdRol) {
        this.rolIdRol = rolIdRol;
    }

    @Id
    @Column(name = "Usuario_idUsuario",insertable=false, updatable=false)
    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
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
        RolHasUsuarioEntity that = (RolHasUsuarioEntity) o;
        return rolIdRol == that.rolIdRol &&
                usuarioIdUsuario == that.usuarioIdUsuario &&
                moduloIdModulo == that.moduloIdModulo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolIdRol, usuarioIdUsuario, moduloIdModulo);
    }

    @ManyToOne
    @JoinColumn(name = "Rol_idRol", referencedColumnName = "idRol",insertable=false, updatable=false)
    public RolEntity getRolByRolIdRol() {
        return rolByRolIdRol;
    }

    public void setRolByRolIdRol(RolEntity rolByRolIdRol) {
        this.rolByRolIdRol = rolByRolIdRol;
    }

    @ManyToOne
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario",insertable=false, updatable=false)
    public UsuarioEntity getUsuarioByUsuarioIdUsuario() {
        return usuarioByUsuarioIdUsuario;
    }

    public void setUsuarioByUsuarioIdUsuario(UsuarioEntity usuarioByUsuarioIdUsuario) {
        this.usuarioByUsuarioIdUsuario = usuarioByUsuarioIdUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "Modulo_idModulo", referencedColumnName = "idModulo",insertable=false, updatable=false)
    public ModuloEntity getModuloByModuloIdModulo() {
        return moduloByModuloIdModulo;
    }

    public void setModuloByModuloIdModulo(ModuloEntity moduloByModuloIdModulo) {
        this.moduloByModuloIdModulo = moduloByModuloIdModulo;
    }
}
