package com.viden.bandtec.videnws.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContrato;

    @NotNull
    private String quemEnviou;

    @JsonIgnore
    @Column(length = 20_000_000)
    private byte[] contrato;

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public byte[] getContrato() {
        return contrato;
    }

    public void setContrato(byte[] contrato) {
        this.contrato = contrato;
    }

    public String getQuemEnviou() {
        return quemEnviou;
    }

    public void setQuemEnviou(String quemEnviou) {
        this.quemEnviou = quemEnviou;
    }
}
