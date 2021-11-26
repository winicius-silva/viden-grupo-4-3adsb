package com.viden.bandtec.videnws.dominio;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class VideoCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVideoCurso;

    @ManyToOne
    @NotNull
    private Curso idCurso;

    @NotNull
    private String link;

    @NotNull
    private String descricaoVideo;

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

    public String getDescricaoVideo() {
        return descricaoVideo;
    }

    public void setDescricaoVideo(String descricaoVideo) {
        this.descricaoVideo = descricaoVideo;
    }
}
