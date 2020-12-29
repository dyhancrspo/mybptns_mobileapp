package com.example.mybtpns.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class Mutasi {

    private int idMutasi;

    private String noRekening;

    private Double jumlahMutasi;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Timestamp waktuMutasi;

    public int getIdMutasi() {
        return idMutasi;
    }

    public void setIdMutasi(int idMutasi) {
        this.idMutasi = idMutasi;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    public Double getJumlahMutasi() {
        return jumlahMutasi;
    }

    public void setJumlahMutasi(Double jumlahMutasi) {
        this.jumlahMutasi = jumlahMutasi;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getWaktuMutasi() {
        return waktuMutasi;
    }

    public void setWaktuMutasi(Timestamp waktuMutasi) {
        this.waktuMutasi = waktuMutasi;
    }
}