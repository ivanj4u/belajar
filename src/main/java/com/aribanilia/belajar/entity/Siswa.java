package com.aribanilia.belajar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "siswa")
public class Siswa {

    @Id
    @Column(length = 11, nullable = false)
    private long id;

    @Column(length = 10)
    private String nik;

    @Column(length = 999)
    private String nama;

    @Column(name = "jenis_kelamin", length = 1)
    private String jenisKelamin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
}
