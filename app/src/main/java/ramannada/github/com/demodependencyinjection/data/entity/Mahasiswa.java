package ramannada.github.com.demodependencyinjection.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ramannada on 1/18/2018.
 */

public class Mahasiswa {
    @SerializedName("npm")
    private String npm;
    @SerializedName("nama")
    private String nama;
    @SerializedName("prodi")
    private String prodi;
    @SerializedName("fakultas")
    private String fakultas;

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }
}
