package com.valorcompartido.springboot.app.model.entity;

import com.valorcompartido.springboot.app.model.emuns.TipoPregunta;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "pregunta", schema = "valorpoli", catalog = "")
public class PreguntaEntity {
    private int idPregunta;
    private String titulo;
    private TipoPregunta tipoPregunta;
    private int quizIdQuiz;
    private Collection<IntentoUsuarioEntity> intentoUsuariosByIdPregunta;
    private QuizEntity quizByQuizIdQuiz;
    private Collection<RespuestaEntity> respuestasByIdPregunta;

    @Id
    @Column(name = "idPregunta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Basic
    @Column(name = "titulo",  length = 45)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "tipoPregunta")
    public TipoPregunta getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(TipoPregunta tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    @Basic
    @Column(name = "Quiz_idQuiz",insertable=false, updatable=false)
    public int getQuizIdQuiz() {
        return quizIdQuiz;
    }

    public void setQuizIdQuiz(int quizIdQuiz) {
        this.quizIdQuiz = quizIdQuiz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreguntaEntity that = (PreguntaEntity) o;
        return idPregunta == that.idPregunta &&
                tipoPregunta == that.tipoPregunta &&
                quizIdQuiz == that.quizIdQuiz &&
                Objects.equals(titulo, that.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPregunta, titulo, tipoPregunta, quizIdQuiz);
    }

    @OneToMany(mappedBy = "preguntaByPreguntaIdPregunta")
    public Collection<IntentoUsuarioEntity> getIntentoUsuariosByIdPregunta() {
        return intentoUsuariosByIdPregunta;
    }

    public void setIntentoUsuariosByIdPregunta(Collection<IntentoUsuarioEntity> intentoUsuariosByIdPregunta) {
        this.intentoUsuariosByIdPregunta = intentoUsuariosByIdPregunta;
    }

    @ManyToOne
    @JoinColumn(name = "Quiz_idQuiz", referencedColumnName = "idQuiz")
    public QuizEntity getQuizByQuizIdQuiz() {
        return quizByQuizIdQuiz;
    }

    public void setQuizByQuizIdQuiz(QuizEntity quizByQuizIdQuiz) {
        this.quizByQuizIdQuiz = quizByQuizIdQuiz;
    }

    @OneToMany(mappedBy = "preguntaByPreguntaIdPregunta")
    public Collection<RespuestaEntity> getRespuestasByIdPregunta() {
        return respuestasByIdPregunta;
    }

    public void setRespuestasByIdPregunta(Collection<RespuestaEntity> respuestasByIdPregunta) {
        this.respuestasByIdPregunta = respuestasByIdPregunta;
    }
}
