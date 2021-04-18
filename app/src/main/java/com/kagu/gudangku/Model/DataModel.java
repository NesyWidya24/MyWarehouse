package com.kagu.gudangku.Model;

public class DataModel {
    int id;
    String kodeGudang;
    String kodeBarang;
    String namaBarang;
    String jenisBarang;
    String jumlahStok;
    String satuan;
    String userId;

    public DataModel() {
    }

    public DataModel(int id, String kodeGudang, String kodeBarang, String namaBarang, String jenisBarang, String jumlahStok, String satuan, String userId) {
        this.id = id;
        this.kodeGudang = kodeGudang;
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.jenisBarang = jenisBarang;
        this.jumlahStok = jumlahStok;
        this.satuan = satuan;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKodeGudang() {
        return kodeGudang;
    }

    public void setKodeGudang(String kodeGudang) {
        this.kodeGudang = kodeGudang;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public String getJumlahStok() {
        return jumlahStok;
    }

    public void setJumlahStok(String jumlahStok) {
        this.jumlahStok = jumlahStok;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
