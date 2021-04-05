/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Controller.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class DetailPemesananDao {
    Koneksi con;
    Statement st;
    ResultSet res;
    String query;
    
    public String NoDetailPembelian() {
        String noDetail = "";
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("select *from dt_masuk ORDER BY iddetailmasuk DESC");
            if (res.first() == false) {
                noDetail = ("DT-IN0001");
            } else {
                res.first();
                System.out.println("COT: " + res.getString("iddetailmasuk").substring(5, 9));
                int nokirim = Integer.valueOf(res.getString("iddetailmasuk").substring(5, 9)) + 1;
                System.out.println(nokirim);
                if (nokirim < 10) {
                    noDetail = ("DT-IN000" + nokirim);
                } else if (nokirim >= 10 && nokirim < 100) {
                    noDetail = ("DT-IN00" + nokirim);
                } else if (nokirim >= 100 && nokirim < 1000) {
                    noDetail = ("DT-IN0" + nokirim);
                } else if (nokirim >= 1000 && nokirim < 9999) {
                   noDetail = ("DT-IN" + nokirim);
                }
            }
            res.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        }
        
        return noDetail;
    }
    
    public void SaveDetail(String idmasuk, String idbarang, String namabarang, int jumlah) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into dt_masuk(idmasuk, idbarang,namabarang, jumlah, status)values('" + idmasuk + "','" + idbarang + "','" + namabarang + "','" + jumlah + "', 'Proses')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di Tambahkan");
        } catch (SQLException e) {
        }
    }
    
    public void Update(String iddetailmasuk, String idmasuk, String idbarang, int jumlah) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update dt_masuk set idbarang='" + idbarang + "' where iddetailmasuk = '" + iddetailmasuk + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {

        }
    }
    
    public void DeleteDetail(String iddetailmasuk) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from dt_masuk where iddetailmasuk = '" + iddetailmasuk + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
        } catch (SQLException e) {

        }
    }

    public String[][] ShowData( String idMasuk) {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(iddetailmasuk) AS Jumlah FROM dt_masuk;";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from dt_masuk where idmasuk = '"+idMasuk+"'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][4];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("iddetailmasuk");
                data[r][1] = res.getString("idbarang");
                data[r][2] = res.getString("jumlah");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][3];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 3; c++) {
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
