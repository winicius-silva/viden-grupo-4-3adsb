package com.viden.bandtec.videnws.dominio;

import javax.persistence.*;

@Entity
@Table(name = "tb_empresa_curso")
public class EmpresaCurso {

    @Column(name = "fk_empresa")
    private Integer fkEmpresa;

    @Column(name = "fk_curso")
    private Integer fkCurso;

    @Column(name = "data")
    private Integer data;

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    public Integer getFkCurso() {
        return fkCurso;
    }

    public void setFkCurso(Integer fkCurso) {
        this.fkCurso = fkCurso;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}
