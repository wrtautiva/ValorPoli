package com.valorcompartido.springboot.app.model.entity;

import com.valorcompartido.springboot.app.model.emuns.Estado;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "modulo", schema = "valorpoli", catalog = "")
public class ModuloEntity {
    private int idModulo;
    private String titulo;
    private String fechaCreacion;
    private Estado estado;
    private String tipoContenido;
    private int usuarioIdUsuario;
    private int subCategoriaIdSubCategoria;
    private Collection<CartaAprendizajeEntity> cartaAprendizajesByIdModulo;
    private UsuarioEntity usuarioByUsuarioIdUsuario;
    private SubCategoriaEntity subCategoriaBySubCategoriaIdSubCategoria;
    private Collection<QuizEntity> quizzesByIdModulo;
    private Collection<RolHasUsuarioEntity> rolHasUsuariosByIdModulo;

    @Id
    @Column(name = "idModulo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
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

    @Basic
    @Column(name = "tipoContenido", nullable = true, length = 45)
    public String getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    @Basic
    @Column(name = "Usuario_idUsuario",insertable=false, updatable=false)
    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    @Basic
    @Column(name = "Sub_Categoria_id_subCategoria",insertable=false, updatable=false)
    public int getSubCategoriaIdSubCategoria() {
        return subCategoriaIdSubCategoria;
    }

    public void setSubCategoriaIdSubCategoria(int subCategoriaIdSubCategoria) {
        this.subCategoriaIdSubCategoria = subCategoriaIdSubCategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModuloEntity that = (ModuloEntity) o;
        return idModulo == that.idModulo &&
                usuarioIdUsuario == that.usuarioIdUsuario &&
                subCategoriaIdSubCategoria == that.subCategoriaIdSubCategoria &&
                Objects.equals(titulo, that.titulo) &&
                Objects.equals(fechaCreacion, that.fechaCreacion) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(tipoContenido, that.tipoContenido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idModulo, titulo, fechaCreacion, estado, tipoContenido, usuarioIdUsuario, subCategoriaIdSubCategoria);
    }

    @OneToMany(mappedBy = "moduloByModuloIdModulo")
    public Collection<CartaAprendizajeEntity> getCartaAprendizajesByIdModulo() {
        return cartaAprendizajesByIdModulo;
    }

    public void setCartaAprendizajesByIdModulo(Collection<CartaAprendizajeEntity> cartaAprendizajesByIdModulo) {
        this.cartaAprendizajesByIdModulo = cartaAprendizajesByIdModulo;
    }

    @ManyToOne
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario")
    public UsuarioEntity getUsuarioByUsuarioIdUsuario() {
        return usuarioByUsuarioIdUsuario;
    }

    public void setUsuarioByUsuarioIdUsuario(UsuarioEntity usuarioByUsuarioIdUsuario) {
        this.usuarioByUsuarioIdUsuario = usuarioByUsuarioIdUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "Sub_Categoria_id_subCategoria", referencedColumnName = "id_subCategoria")
    public SubCategoriaEntity getSubCategoriaBySubCategoriaIdSubCategoria() {
        return subCategoriaBySubCategoriaIdSubCategoria;
    }

    public void setSubCategoriaBySubCategoriaIdSubCategoria(SubCategoriaEntity subCategoriaBySubCategoriaIdSubCategoria) {
        this.subCategoriaBySubCategoriaIdSubCategoria = subCategoriaBySubCategoriaIdSubCategoria;
    }

    @OneToMany(mappedBy = "moduloByModuloIdModulo")
    public Collection<QuizEntity> getQuizzesByIdModulo() {
        return quizzesByIdModulo;
    }

    public void setQuizzesByIdModulo(Collection<QuizEntity> quizzesByIdModulo) {
        this.quizzesByIdModulo = quizzesByIdModulo;
    }

    @OneToMany(mappedBy = "moduloByModuloIdModulo")
    public Collection<RolHasUsuarioEntity> getRolHasUsuariosByIdModulo() {
        return rolHasUsuariosByIdModulo;
    }

    public void setRolHasUsuariosByIdModulo(Collection<RolHasUsuarioEntity> rolHasUsuariosByIdModulo) {
        this.rolHasUsuariosByIdModulo = rolHasUsuariosByIdModulo;
    }
}
