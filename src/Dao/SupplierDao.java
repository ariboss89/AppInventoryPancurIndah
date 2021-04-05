/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Controller.Koneksi;
import Models.tb_supplier;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class SupplierDao extends tb_supplier{

    Koneksi con;
    Statement st;
    ResultSet res;
    String idSupplier;
    String query;

    public String IdSupplier() {
        idSupplier = "";
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("select *from tb_supplier ORDER BY idsupplier DESC");
            if (res.first() == false) {
                idSupplier = ("S0001");
            } else {
                res.first();
                System.out.println("COT: " + res.getString("idsupplier").substring(1, 5));
                int no = Integer.valueOf(res.getString("idsupplier").substring(1, 5)) + 1;
                System.out.println(no);
                if (no < 10) {
                    idSupplier = ("S000" + no);
                } else if (no >= 10 && no < 100) {
                    idSupplier = ("S00" + no);
                } else if (no >= 100 && no < 1000) {
                    idSupplier = ("SB0" + no);
                } else if (no >= 1000 && no < 9999) {
                    idSupplier = ("S" + no);
                }
            }
            res.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        }

        return idSupplier;
    }

    public void Save(String idsupplier, String nama, String kontak, String alamat) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_supplier(idsupplier, nama, kontak, alamat)values('" + idsupplier + "','" + nama + "','" + kontak + "','" + alamat + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
        }
    }

    public void Update(String idsupplier, String nama, String kontak, String alamat) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_supplier set nama='" + nama + "', kontak = '" + kontak + "', alamat='" + alamat + "' where idsupplier = '" + idsupplier + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {

        }
    }

    public void Delete(String idsupplier) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_supplier where idsupplier = '" + idsupplier + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
        } catch (SQLException e) {

        }
    }

    public String[][] ShowData() {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(idsupplier) AS Jumlah FROM tb_supplier;";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_supplier";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][4];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("idsupplier");
                data[r][1] = res.getString("nama");
                data[r][2] = res.getString("kontak");
                data[r][3] = res.getString("alamat");
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

    public String[][] SearchData(String idsupplier) {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(idsupplier) AS Jumlah FROM tb_supplier";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_supplier where idsupplier like '%" + idsupplier + "%'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][4];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("idsupplier");
                data[r][1] = res.getString("nama");
                data[r][2] = res.getString("kontak");
                data[r][3] = res.getString("alamat");
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

    public ArrayList<String> ShowSupplier() {
        String namaSupplier = "";
        ArrayList<String> listSupplier = new ArrayList<String>();
        con = new Koneksi();
        con.connect();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_supplier");
            while (res.next()) {
                listSupplier.add(res.getString("nama"));
            }
        } catch (SQLException ex) {

        }

        return listSupplier;
    }

    public ArrayList<String> ShowBySupplierName(String nama) {

        ArrayList<String> list = new ArrayList<String>();

        con = new Koneksi();
        con.connect();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_supplier WHERE nama = '" + nama + "'");
            while (res.next()) {
                list.add(res.getString("idsupplier"));
                list.add(res.getString("alamat"));
                list.add(res.getString("kontak"));
            }
        } catch (SQLException ex) {

        }

        return list;
    }
}
