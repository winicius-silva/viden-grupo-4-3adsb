package com.viden.bandtec.videnws.dominio;

import javax.persistence.*;

@Entity
public class VideoCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVideoCurso;
    @ManyToOne
    private Curso idCurso;
    private String link;

    public Integer getIdVideoCurso() {
        return idVideoCurso;
    }

    public void setIdVideoCurso(Integer idVideoCurso) {
        this.idVideoCurso = idVideoCurso;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
