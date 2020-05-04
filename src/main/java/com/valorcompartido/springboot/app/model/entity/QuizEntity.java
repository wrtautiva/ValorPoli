package com.valorcompartido.springboot.app.model.entity;

import com.valorcompartido.springboot.app.model.emuns.Estado;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "quiz", schema = "valorpoli", catalog = "")
public class QuizEntity {
    private int idQuiz;
    private String titulo;
    private String descripcion;
    private int moduloIdModulo;
    private Estado estado;
    private Collection<PreguntaEntity> preguntasByIdQuiz;
    private ModuloEntity moduloByModuloIdModulo;

    @Id
    @Column(name = "idQuiz")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(int idQuiz) {
        this.idQuiz = idQuiz;
    }

    @Basic
    @Column(name = "titulo", nullable = true, length = 45)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "descripcion", nullable = true, length = 45)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "Modulo_idModulo",insertable=false, updatable=false)
    public int getModuloIdModulo() {
        return moduloIdModulo;
    }

    public void setModuloIdModulo(int moduloIdModulo) {
        this.moduloIdModulo = moduloIdModulo;
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
        QuizEntity that = (QuizEntity) o;
        return idQuiz == that.idQuiz &&
                moduloIdModulo == that.moduloIdModulo &&
                Objects.equals(titulo, that.titulo) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuiz, titulo, descripcion, moduloIdModulo);
    }

    @OneToMany(mappedBy = "quizByQuizIdQuiz")
    public Collection<PreguntaEntity> getPreguntasByIdQuiz() {
        return preguntasByIdQuiz;
    }

    public void setPreguntasByIdQuiz(Collection<PreguntaEntity> preguntasByIdQuiz) {
        this.preguntasByIdQuiz = preguntasByIdQuiz;
    }

    @ManyToOne
    @JoinColumn(name = "Modulo_idModulo", referencedColumnName = "idModulo")
    public ModuloEntity getModuloByModuloIdModulo() {
        return moduloByModuloIdModulo;
    }

    public void setModuloByModuloIdModulo(ModuloEntity moduloByModuloIdModulo) {
        this.moduloByModuloIdModulo = moduloByModuloIdModulo;
    }
}
