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

/**
 *
 * @author User
 */
public class CekBarangDao {
    
    Koneksi con;
    ResultSet rs;
    Statement st;
    String query;
    
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
            data = new String[jumlahBaris][4];
            int r = 0;
            while (rs.next()) {
                data[r][0] = rs.getString("idbarang");
                data[r][1] = rs.getString("nama");
                data[r][2] = rs.getString("stok");
                data[r][3] = rs.getString("minstok");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][4];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 4; c++) {
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
            data = new String[jumlahBaris][4];
            int r = 0;
            while (rs.next()) {
                data[r][0] = rs.getString("idbarang");
                data[r][1] = rs.getString("nama");
                data[r][2] = rs.getString("stok");
                data[r][3] = rs.getString("minstok");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][4];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c <4; c++) {
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
