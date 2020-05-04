package com.valorcompartido.springboot.app.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "comentario", schema = "valorpoli", catalog = "")
public class ComentarioEntity {
    private int idComentario;
    private String comentario;
    private Timestamp fechaCreacion;
    private int estado;
    private int cartaAprendizajeIdCarta;
    private int usuarioIdUsuario;
    private CartaAprendizajeEntity cartaAprendizajeByCartaAprendizajeIdCarta;
    private UsuarioEntity usuarioByUsuarioIdUsuario;

    @Id
    @Column(name = "idComentario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    @Basic
    @Column(name = "comentario", nullable = true, length = 200)
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Basic
    @Column(name = "fecha_creacion")
    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Basic
    @Column(name = "estado")
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "Carta_aprendizaje_idCarta",insertable=false, updatable=false)
    public int getCartaAprendizajeIdCarta() {
        return cartaAprendizajeIdCarta;
    }

    public void setCartaAprendizajeIdCarta(int cartaAprendizajeIdCarta) {
        this.cartaAprendizajeIdCarta = cartaAprendizajeIdCarta;
    }

    @Basic
    @Column(name = "Usuario_idUsuario",insertable=false, updatable=false)
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
        ComentarioEntity that = (ComentarioEntity) o;
        return idComentario == that.idComentario &&
                estado == that.estado &&
                cartaAprendizajeIdCarta == that.cartaAprendizajeIdCarta &&
                usuarioIdUsuario == that.usuarioIdUsuario &&
                Objects.equals(comentario, that.comentario) &&
                Objects.equals(fechaCreacion, that.fechaCreacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComentario, comentario, fechaCreacion, estado, cartaAprendizajeIdCarta, usuarioIdUsuario);
    }

    @ManyToOne
    @JoinColumn(name = "Carta_aprendizaje_idCarta", referencedColumnName = "idCarta")
    public CartaAprendizajeEntity getCartaAprendizajeByCartaAprendizajeIdCarta() {
        return cartaAprendizajeByCartaAprendizajeIdCarta;
    }

    public void setCartaAprendizajeByCartaAprendizajeIdCarta(CartaAprendizajeEntity cartaAprendizajeByCartaAprendizajeIdCarta) {
        this.cartaAprendizajeByCartaAprendizajeIdCarta = cartaAprendizajeByCartaAprendizajeIdCarta;
    }

    @ManyToOne
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario")
    public UsuarioEntity getUsuarioByUsuarioIdUsuario() {
        return usuarioByUsuarioIdUsuario;
    }

    public void setUsuarioByUsuarioIdUsuario(UsuarioEntity usuarioByUsuarioIdUsuario) {
        this.usuarioByUsuarioIdUsuario = usuarioByUsuarioIdUsuario;
    }
}
