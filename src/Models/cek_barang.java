/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

/**
 *
 * @author User
 */
public class cek_barang {
    public static String idbarang;
    public static String nama;
    public static int harga;
    public static int stok;

    public static String getIdbarang() {
        return idbarang;
    }

    public static void setIdbarang(String idbarang) {
        cek_barang.idbarang = idbarang;
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        cek_barang.nama = nama;
    }

    public static int getHarga() {
        return harga;
    }

    public static void setHarga(int harga) {
        cek_barang.harga = harga;
    }

    public static int getStok() {
        return stok;
    }

    public static void setStok(int stok) {
        cek_barang.stok = stok;
    }
    
}
