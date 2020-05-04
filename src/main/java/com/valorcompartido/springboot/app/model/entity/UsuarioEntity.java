package com.valorcompartido.springboot.app.model.entity;

import com.valorcompartido.springboot.app.model.emuns.Estado;
import com.valorcompartido.springboot.app.model.emuns.TipoDocumento;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "usuario", schema = "valorpoli", catalog = "")
public class UsuarioEntity {
    private int idUsuario;
    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String ocupacion;
    private String descripcion;
    private String imagenPerfil;
    private Estado estado;
    private Collection<ComentarioEntity> comentariosByIdUsuario;
    private Collection<IntentoUsuarioEntity> intentoUsuariosByIdUsuario;
    private Collection<ModuloEntity> modulosByIdUsuario;
    private Collection<RolHasUsuarioEntity> rolHasUsuariosByIdUsuario;

    @Id
    @Column(name = "idUsuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Basic
    @Column(name = "tipoDocumento", nullable = true, length = 3)
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Basic
    @Column(name = "numeroDocumento", nullable = true, length = 11,unique = true)
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 45)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "apellido", nullable = true, length = 45)
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 42)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "ocupacion", nullable = true, length = 60)
    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Basic
    @Column(name = "descripcion", nullable = true, length = 200)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "imagenPerfil", nullable = true, length = 75)
    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
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
        UsuarioEntity that = (UsuarioEntity) o;
        return idUsuario == that.idUsuario &&
                Objects.equals(tipoDocumento, that.tipoDocumento) &&
                Objects.equals(numeroDocumento, that.numeroDocumento) &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(apellido, that.apellido) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(ocupacion, that.ocupacion) &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(imagenPerfil, that.imagenPerfil) &&
                Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, tipoDocumento, numeroDocumento, nombre, apellido, email, password, ocupacion, descripcion, imagenPerfil, estado);
    }

    @OneToMany(mappedBy = "usuarioByUsuarioIdUsuario")
    public Collection<ComentarioEntity> getComentariosByIdUsuario() {
        return comentariosByIdUsuario;
    }

    public void setComentariosByIdUsuario(Collection<ComentarioEntity> comentariosByIdUsuario) {
        this.comentariosByIdUsuario = comentariosByIdUsuario;
    }

    @OneToMany(mappedBy = "usuarioByUsuarioIdUsuario")
    public Collection<IntentoUsuarioEntity> getIntentoUsuariosByIdUsuario() {
        return intentoUsuariosByIdUsuario;
    }

    public void setIntentoUsuariosByIdUsuario(Collection<IntentoUsuarioEntity> intentoUsuariosByIdUsuario) {
        this.intentoUsuariosByIdUsuario = intentoUsuariosByIdUsuario;
    }

    @OneToMany(mappedBy = "usuarioByUsuarioIdUsuario")
    public Collection<ModuloEntity> getModulosByIdUsuario() {
        return modulosByIdUsuario;
    }

    public void setModulosByIdUsuario(Collection<ModuloEntity> modulosByIdUsuario) {
        this.modulosByIdUsuario = modulosByIdUsuario;
    }

    @OneToMany(mappedBy = "usuarioByUsuarioIdUsuario")
    public Collection<RolHasUsuarioEntity> getRolHasUsuariosByIdUsuario() {
        return rolHasUsuariosByIdUsuario;
    }

    public void setRolHasUsuariosByIdUsuario(Collection<RolHasUsuarioEntity> rolHasUsuariosByIdUsuario) {
        this.rolHasUsuariosByIdUsuario = rolHasUsuariosByIdUsuario;
    }
}
