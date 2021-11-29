package com.viden.bandtec.videnws.dominio;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class VideoCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVideoCurso;

    @NotNull
    private Integer fkCurso;

    @NotNull
    private String link;

    @NotNull
    private String titulo;

    @NotNull
    private String descricaoVideo;

    @NotNull
    @Min(1)
    private Integer indice;

    public Integer getIdVideoCurso() {
        return idVideoCurso;
    }

    public void setIdVideoCurso(Integer idVideoCurso) {
        this.idVideoCurso = idVideoCurso;
    }

    public Integer getFkCurso() {
        return fkCurso;
    }

    public void setFkCurso(Integer fkCurso) {
        this.fkCurso = fkCurso;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }
}
