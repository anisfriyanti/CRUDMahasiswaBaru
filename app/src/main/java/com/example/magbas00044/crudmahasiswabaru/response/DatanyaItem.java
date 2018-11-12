package com.example.magbas00044.crudmahasiswabaru.response;


import com.google.gson.annotations.SerializedName;


public class DatanyaItem {

    @SerializedName("mahasiswa_jurusan")
    private String mahasiswaJurusan;

    @SerializedName("mahasiswa_nama")
    private String mahasiswaNama;

    @SerializedName("mahasiswa_id")
    private String mahasiswaId;

    @SerializedName("mahasiswa_nim")
    private String mahasiswaNim;

    @SerializedName("mahasiswa_foto")
    private String mahasiswaFoto;

    public void setMahasiswaJurusan(String mahasiswaJurusan) {
        this.mahasiswaJurusan = mahasiswaJurusan;
    }

    public String getMahasiswaJurusan() {
        return mahasiswaJurusan;
    }

    public void setMahasiswaNama(String mahasiswaNama) {
        this.mahasiswaNama = mahasiswaNama;
    }

    public String getMahasiswaNama() {
        return mahasiswaNama;
    }

    public void setMahasiswaId(String mahasiswaId) {
        this.mahasiswaId = mahasiswaId;
    }

    public String getMahasiswaId() {
        return mahasiswaId;
    }

    public void setMahasiswaNim(String mahasiswaNim) {
        this.mahasiswaNim = mahasiswaNim;
    }

    public String getMahasiswaNim() {
        return mahasiswaNim;
    }

    public void setMahasiswaFoto(String mahasiswaFoto) {
        this.mahasiswaFoto = mahasiswaFoto;
    }

    public String getMahasiswaFoto() {
        return mahasiswaFoto;
    }

    @Override
    public String toString() {
        return
                "DatanyaItem{" +
                        "mahasiswa_jurusan = '" + mahasiswaJurusan + '\'' +
                        ",mahasiswa_nama = '" + mahasiswaNama + '\'' +
                        ",mahasiswa_id = '" + mahasiswaId + '\'' +
                        ",mahasiswa_nim = '" + mahasiswaNim + '\'' +
                        ",mahasiswa_foto = '" + mahasiswaFoto + '\'' +
                        "}";
    }
}