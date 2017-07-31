package me.anjas.educationvee.objects;

/**
 * Created by anjas on 30/07/17.
 */

public class Jobsheet {
    String title;
    String description;
    int status;
    int kompetensi;
    int subKompetensi;
    int landasanTeori;
    int alatBahan;
    int keselematanKerja;
    int langkahPercobaan;
    int latihan;
    int gambar;

    public Jobsheet(String title, String description, int status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Jobsheet(String title, String description, int status, int kompentensi, int subKompetensi, int landasanTeori, int alatBahan, int keselematanKerja, int langkahPercobaan, int latihan, int gambar) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.kompetensi = kompentensi;
        this.subKompetensi = subKompetensi;
        this.landasanTeori = landasanTeori;
        this.alatBahan = alatBahan;
        this.keselematanKerja = keselematanKerja;
        this.langkahPercobaan = langkahPercobaan;
        this.latihan = latihan;
        this.gambar = gambar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getKompetensi() {
        return kompetensi;
    }

    public void setKompetensi(int kompetensi) {
        this.kompetensi = kompetensi;
    }

    public int getSubKompetensi() {
        return subKompetensi;
    }

    public void setSubKompetensi(int subKompetensi) {
        this.subKompetensi = subKompetensi;
    }

    public int getLandasanTeori() {
        return landasanTeori;
    }

    public void setLandasanTeori(int landasanTeori) {
        this.landasanTeori = landasanTeori;
    }

    public int getAlatBahan() {
        return alatBahan;
    }

    public void setAlatBahan(int alatBahan) {
        this.alatBahan = alatBahan;
    }

    public int getKeselematanKerja() {
        return keselematanKerja;
    }

    public void setKeselematanKerja(int keselematanKerja) {
        this.keselematanKerja = keselematanKerja;
    }

    public int getLangkahPercobaan() {
        return langkahPercobaan;
    }

    public void setLangkahPercobaan(int langkahPercobaan) {
        this.langkahPercobaan = langkahPercobaan;
    }

    public int getLatihan() {
        return latihan;
    }

    public void setLatihan(int latihan) {
        this.latihan = latihan;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
