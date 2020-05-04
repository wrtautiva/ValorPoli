package com.valorcompartido.springboot.app.model.entity;

import com.valorcompartido.springboot.app.model.emuns.Estado;
import com.valorcompartido.springboot.app.services.IntentoUsuarioService;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "respuesta", schema = "valorpoli", catalog = "")
public class RespuestaEntity {
    private int idRespuesta;
    private String respuesta;
    private Estado correcta;
    private int preguntaIdPregunta;
    private Collection<IntentoUsuarioEntity> respuestaByIntentoUsuario;
    private PreguntaEntity preguntaByPreguntaIdPregunta;

    @Id
    @Column(name = "idRespuesta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    @Basic
    @Column(name = "respuesta", nullable = true, length = 45)
    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Basic
    @Column(name = "correcta")
    public Estado getCorrecta() {
        return correcta;
    }

    public void setCorrecta(Estado correcta) {
        this.correcta = correcta;
    }

    @Basic
    @Column(name = "Pregunta_idPregunta",insertable=false, updatable=false)
    public int getPreguntaIdPregunta() {
        return preguntaIdPregunta;
    }

    public void setPreguntaIdPregunta(int preguntaIdPregunta) {
        this.preguntaIdPregunta = preguntaIdPregunta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RespuestaEntity that = (RespuestaEntity) o;
        return idRespuesta == that.idRespuesta &&
                correcta == that.correcta &&
                //preguntaIdPregunta == that.preguntaIdPregunta &&
                Objects.equals(respuesta, that.respuesta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRespuesta, respuesta, correcta);// ,preguntaIdPregunta);
    }

    @OneToMany(mappedBy = "respuestaByRespuestaByIdRespuesta")
    public Collection<IntentoUsuarioEntity> getIntentoUsuarioByIdRespuesta() {
        return respuestaByIntentoUsuario;
    }

    public void setIntentoUsuarioByIdRespuesta(Collection<IntentoUsuarioEntity> intentoByintentoIdIntentoUsuario) {
        this.respuestaByIntentoUsuario = intentoByintentoIdIntentoUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "Pregunta_idPregunta", referencedColumnName = "idPregunta")
    public PreguntaEntity getPreguntaByPreguntaIdPregunta() {
        return preguntaByPreguntaIdPregunta;
    }

    public void setPreguntaByPreguntaIdPregunta(PreguntaEntity preguntaByPreguntaIdPregunta) {
        this.preguntaByPreguntaIdPregunta = preguntaByPreguntaIdPregunta;
    }
}
