/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Controller.Koneksi;
import Models.tb_barang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class BarangDao extends tb_barang{
    private Koneksi con;
    private ResultSet rs;
    private Statement st;
    private String query;
    
    public String IdBarang(){ 
        
        String idBarang= "";
        java.sql.Connection conn = new Koneksi().connect();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select *from tb_barang ORDER BY idbarang DESC");
            if (rs.first() == false) {
                idBarang = ("B0001");
            } else {
                rs.first();
                System.out.println("COT: " + rs.getString("idbarang").substring(1, 5));
                int nokirim = Integer.valueOf(rs.getString("idbarang").substring(1, 5)) + 1;
                System.out.println(nokirim);
                if (nokirim < 10) {
                    idBarang = ("B000" + nokirim);
                } else if (nokirim >= 10 && nokirim < 100) {
                    idBarang = ("B00" + nokirim);
                } else if (nokirim >= 100 && nokirim < 1000) {
                    idBarang = ("B0" + nokirim);
                } else if (nokirim >= 1000 && nokirim < 9999) {
                    idBarang = ("B" + nokirim);
                }
            }
            rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        }
        
        return idBarang;
    }
    
    public void Save(String idbarang, String nama, String kategori, String satuan, int hargabeli, int hargajual, int stok, int minstok) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_barang(idbarang, nama, kategori, satuan, hargabeli, hargajual,stok, minstok)values('" + idbarang + "','" + nama + "','" + kategori + "','" +satuan + "','" + hargabeli + "','" + hargajual + "','" + stok + "','" + minstok + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
        }
    }
    
    public void Update(String idbarang, String nama, String kategori, String satuan, int hargabeli, int hargajual, int minstok) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_barang set nama='" + nama + "', kategori='" + kategori + "', satuan='" + satuan + "', hargabeli='" + hargabeli + "', hargajual='" + hargajual + "', minstok='" + minstok + "' where idbarang = '" + idbarang + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {

        }
    }
    
    public void Delete(String idbarang) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_barang where idbarang = '" + idbarang + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
        } catch (SQLException e) {

        }
    }

    public String[][] ShowData() {

        rs = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(idbarang) AS Jumlah FROM tb_barang;";
            rs = st.executeQuery(query);
            if (rs.next()) {
                jumlahBaris = rs.getInt("Jumlah");
            }
            query = "select *from tb_barang";
            rs = st.executeQuery(query);
            data = new String[jumlahBaris][8];
            int r = 0;
            while (rs.next()) {
                data[r][0] = rs.getString("idbarang");
                data[r][1] = rs.getString("nama");
                data[r][2] = rs.getString("kategori");
                data[r][3] = rs.getString("satuan");
                data[r][4] = rs.getString("hargabeli");
                data[r][5] = rs.getString("hargajual");
                data[r][6] = rs.getString("stok");
                data[r][7] = rs.getString("minstok");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][8];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 8; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }

    public String[][] SearchData(String search) {

        rs = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(idbarang) AS Jumlah FROM tb_barang";
            rs = st.executeQuery(query);
            if (rs.next()) {
                jumlahBaris = rs.getInt("Jumlah");
            }
            query = "select *from tb_barang where idbarang like '%"+ search +"%' or nama like '%"+ search +"%'";
            rs = st.executeQuery(query);
            data = new String[jumlahBaris][8];
            int r = 0;
            while (rs.next()) {
                data[r][0] = rs.getString("idbarang");
                data[r][1] = rs.getString("nama");
                data[r][2] = rs.getString("kategori");
                data[r][3] = rs.getString("satuan");
                data[r][4] = rs.getString("hargabeli");
                data[r][5] = rs.getString("hargajual");
                data[r][6] = rs.getString("stok");
                data[r][7] = rs.getString("minstok");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][8];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c <8; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }
}
