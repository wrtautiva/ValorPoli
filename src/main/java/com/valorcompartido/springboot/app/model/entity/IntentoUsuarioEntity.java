package com.valorcompartido.springboot.app.model.entity;

import com.valorcompartido.springboot.app.model.emuns.Estado;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "intento_usuario", schema = "valorpoli", catalog = "")
public class IntentoUsuarioEntity {
    private int idIntentoUsuario;
    private Estado correcta; //3 incorrecta // dos correcta
    private String respuestaAbierta;
    private int usuarioIdUsuario;
    private int preguntaIdPregunta;
    private String fechaRespuesta;
    private UsuarioEntity usuarioByUsuarioIdUsuario;
    private PreguntaEntity preguntaByPreguntaIdPregunta;
    private RespuestaEntity respuestaByRespuestaByIdRespuesta;

    @Id
    @Column(name = "idIntento_usuario")
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    public int getIdIntentoUsuario() {
        return idIntentoUsuario;
    }

    public void setIdIntentoUsuario(int idIntentoUsuario) {
        this.idIntentoUsuario = idIntentoUsuario;
    }

    @Basic
    @Column(name = "correcta", nullable = true)
    public Estado getCorrecta() {
        return correcta;
    }

    public void setCorrecta(Estado correcta) {
        this.correcta = correcta;
    }

    @Basic
    @Column(name = "respuesta_abierta", nullable = true, length = 200)
    public String getRespuestaAbierta() {
        return respuestaAbierta;
    }

    public void setRespuestaAbierta(String respuestaAbierta) {
        this.respuestaAbierta = respuestaAbierta;
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
    @Column(name = "Pregunta_idPregunta",insertable=false, updatable=false)
    public int getPreguntaIdPregunta() {
        return preguntaIdPregunta;
    }

    public void setPreguntaIdPregunta(int preguntaIdPregunta) {
        this.preguntaIdPregunta = preguntaIdPregunta;
    }

    @Basic
    @Column(name = "fechaRespuesta",insertable=false, updatable=false)
    public String getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(String fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntentoUsuarioEntity that = (IntentoUsuarioEntity) o;
        return idIntentoUsuario == that.idIntentoUsuario &&
                usuarioIdUsuario == that.usuarioIdUsuario &&
                preguntaIdPregunta == that.preguntaIdPregunta &&
                Objects.equals(correcta, that.correcta) &&
                Objects.equals(respuestaAbierta, that.respuestaAbierta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIntentoUsuario, correcta, respuestaAbierta, usuarioIdUsuario, preguntaIdPregunta);
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
    @JoinColumn(name = "Pregunta_idPregunta", referencedColumnName = "idPregunta")
    public PreguntaEntity getPreguntaByPreguntaIdPregunta() {
        return preguntaByPreguntaIdPregunta;
    }

    public void setPreguntaByPreguntaIdPregunta(PreguntaEntity preguntaByPreguntaIdPregunta) {
        this.preguntaByPreguntaIdPregunta = preguntaByPreguntaIdPregunta;
    }

    @ManyToOne
    @JoinColumn(name = "respuesta_idrespuesta", referencedColumnName = "idRespuesta")
    public RespuestaEntity getRespuestaByRespuestaByIdRespuesta() {
        return respuestaByRespuestaByIdRespuesta;
    }

    public void setRespuestaByRespuestaByIdRespuesta(RespuestaEntity respuestasByIdIntentoUsuario) {
        this.respuestaByRespuestaByIdRespuesta = respuestasByIdIntentoUsuario;
    }
}
