/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Controller.Koneksi;
import java.awt.List;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class PemesananDao extends DetailPemesananDao{

    Koneksi con;
    Statement st;
    ResultSet res;
    String query;

    public String NoPembelian() {
        String noPembelian = "";

        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("select *from tr_masuk ORDER BY idmasuk DESC");
            if (res.first() == false) {
                noPembelian = ("IN-0001");
            } else {
                res.first();
                System.out.println("COT: " + res.getString("idmasuk").substring(3, 7));
                int nokirim = Integer.valueOf(res.getString("idmasuk").substring(3, 7)) + 1;
                System.out.println(nokirim);
                if (nokirim < 10) {
                    noPembelian = ("IN-000" + nokirim);
                } else if (nokirim >= 10 && nokirim < 100) {
                    noPembelian = ("IN-00" + nokirim);
                } else if (nokirim >= 100 && nokirim < 1000) {
                    noPembelian = ("IN-0" + nokirim);
                } else if (nokirim >= 1000 && nokirim < 9999) {
                    noPembelian = ("IN-" + nokirim);
                }
            }
            res.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        }

        return noPembelian;

    }
    
    public void Save(String idmasuk, String tanggal, int jumlah, String idsupplier) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tr_masuk(idmasuk, tanggal, jumlah ,idsupplier)values('" + idmasuk + "','" + tanggal + "','" + jumlah +"','"+ idsupplier + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Sedang Mencetak Struk ... ");
        } catch (SQLException e) {
        }
    }
}
