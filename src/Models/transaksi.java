/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

import java.sql.Date;

/**
 *
 * @author User
 */
public class transaksi {
    private String IdDetail;
    private Date tanggalMasuk;
    private int stokBarangMasuk;
    private int stokBarang;
    private int minStokBarang;
    private Date tanggal;
    private int Penampung;
    private String namaBarang;

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getPenampung() {
        return Penampung;
    }

    public void setPenampung(int Penampung) {
        this.Penampung = Penampung;
    }
    
    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Date getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(Date tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }
    
    public String getIdDetail() {
        return IdDetail;
    }

    public void setIdDetail(String IdDetail) {
        this.IdDetail = IdDetail;
    }

    public int getStokBarang() {
        return stokBarang;
    }

    public void setStokBarang(int stokBarang) {
        this.stokBarang = stokBarang;
    }

    public int getStokBarangMasuk() {
        return stokBarangMasuk;
    }

    public void setStokBarangMasuk(int stokBarangMasuk) {
        this.stokBarangMasuk = stokBarangMasuk;
    }

    public int getMinStokBarang() {
        return minStokBarang;
    }

    public void setMinStokBarang(int minStokBarang) {
        this.minStokBarang = minStokBarang;
    }
}
