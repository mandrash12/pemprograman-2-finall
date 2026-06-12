package com.rental.model;

public class Mobil {
    private int id;
    private String nama;
    private String merk;
    private int tahun;
    private String warna;
    private double hargaSewaPerHari;
    private String status;
    private String gambarUrl;
    private String createdAt;

    public Mobil() {
    }

    public Mobil(int id, String nama, String merk, int tahun, String warna,
                 double hargaSewaPerHari, String status, String gambarUrl, String createdAt) {
        this.id = id;
        this.nama = nama;
        this.merk = merk;
        this.tahun = tahun;
        this.warna = warna;
        this.hargaSewaPerHari = hargaSewaPerHari;
        this.status = status;
        this.gambarUrl = gambarUrl;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public double getHargaSewaPerHari() {
        return hargaSewaPerHari;
    }

    public void setHargaSewaPerHari(double hargaSewaPerHari) {
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGambarUrl() {
        return gambarUrl;
    }

    public void setGambarUrl(String gambarUrl) {
        this.gambarUrl = gambarUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
