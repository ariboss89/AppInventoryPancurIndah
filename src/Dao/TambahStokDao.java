/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Controller.Koneksi;
import Models.tr_barang;
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
public class TambahStokDao extends tr_barang{
    
    Koneksi con;
    Statement st;
    ResultSet res;
    String query;
    
    public void Save(String idtransaksibarang, String idbarang, Date tanggal, int jumlah) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tr_barang(idtransaksibarang, idbarang, tanggal, jumlah)values('" + idtransaksibarang + "','" + idbarang + "','" + tanggal + "','" + jumlah +"')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
        }
    }
    
    public void UpdateStok( String idbarang, int stok) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_barang set stok = '"+ stok +"' where idbarang = '" + idbarang + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
        } catch (SQLException e) {

        }
    }
    
    public void Delete(String idtransaksibarang) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tr_barang where idtransaksibarang = '" + idtransaksibarang + "'";
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
            query = "SELECT COUNT(idtransaksibarang) AS Jumlah FROM tr_barang;";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tr_barang";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][4];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("idtransaksibarang");
                data[r][1] = res.getString("idbarang");
                data[r][2] = res.getString("tanggal");
                data[r][3] = res.getString("jumlah");
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

    public String[][] SearchData(String idtransaksibarang, String idbarang) {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(idtransaksibarang) AS Jumlah FROM tr_barang";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tr_barang where idtransaksibarang like '%" + idtransaksibarang + "%' or idbarang like '%"+ idbarang +"%'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][6];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("idtransaksibarang");
                data[r][1] = res.getString("idbarang");
                data[r][2] = res.getString("kategori");
                data[r][3] = res.getString("tanggal");
                data[r][4] = res.getString("idsupplier");
                data[r][5] = res.getString("jumlah");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][6];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c <6; c++) {
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
    
    public void UpdateStatus(String idMasuk) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tr_masuk set status='Selesai' where idmasuk = '" + idMasuk + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            //JOptionPane.showMessageDialog(null, "Status Berhasil di Update");
        } catch (SQLException e) {

        }
    }
    
    public void UpdateStatusDetailBarang(String idDetail) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update dt_masuk set status= 'Selesai' where iddetailmasuk = '"+idDetail+"'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
        } catch (SQLException e) {

        }
    }
    
    public String IdTransaksiBarang() {
        
        String idTransaksi = "";
        con = new Koneksi();
        try {
            Statement st = con.connect().createStatement();
            ResultSet rs = st.executeQuery("select *from tr_barang ORDER BY idtransaksibarang DESC");
            if (rs.first() == false) {
                idTransaksi = ("TRB0001");
            } else {
                rs.first();
                System.out.println("COT: " + rs.getString("idtransaksibarang").substring(3, 7));
                int no = Integer.valueOf(rs.getString("idtransaksibarang").substring(3, 7)) + 1;
                System.out.println(no);
                if (no < 10) {
                    idTransaksi = ("TRB000" + no);
                } else if (no >= 10 && no < 100) {
                    idTransaksi = ("TRB00" + no);
                } else if (no >= 100 && no < 1000) {
                    idTransaksi = ("TRB0" + no);
                } else if (no >= 1000 && no < 9999) {
                    idTransaksi = ("TRB" + no);
                }
            }
            rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        }
        return idTransaksi;
    }
    
    public ArrayList<String> ShowInvoice() {
        ArrayList<String> list = new ArrayList<String>();
        con = new Koneksi();
        con.connect();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT DISTINCT(idmasuk) FROM dt_masuk WHERE status ='Proses' ");
            while (res.next()) {
                list.add(res.getString("idmasuk"));
            }
        } catch (SQLException ex) {

        }

        return list;
    }

    public ArrayList<String> ShowNamaBarang(String idmasuk) {

        ArrayList<String> list = new ArrayList<String>();

        con = new Koneksi();
        con.connect();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM dt_masuk WHERE idmasuk = '" + idmasuk + "' AND status = 'Proses'");
            if (res.next()) {
                list.add(res.getString("iddetailmasuk"));
                list.add(res.getString("idbarang"));
                list.add(res.getString("namabarang"));
                list.add(res.getString("jumlah"));
            }
        } catch (SQLException ex) {

        }

        return list;
    }
    
    public ArrayList<String> ShowDataByNamaBarang(String idMasuk, String namaBarang) {

        ArrayList<String> list = new ArrayList<String>();

        con = new Koneksi();
        con.connect();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM dt_masuk WHERE idmasuk = '" + idMasuk + "' AND namabarang = '"+namaBarang+"'");
            while (res.next()) {
                list.add(res.getString("idbarang"));
                list.add(res.getString("jumlah"));
            }
        } catch (SQLException ex) {

        }

        return list;
    }
    
//    public String ShowIdSupplier(String invoice){
//        String Id = "";
//        con= new Koneksi();
//        try{
//            st = con.connect().createStatement();
//            res = st.executeQuery("SELECT *FROM tr_masuk WHERE idmasuk = '"+invoice+"'");
//            while(res.next()){
//                Id = res.getString("idsupplier");
//            }
//        }catch(SQLException ex){
//            
//        }
//        return Id;
//    } 
//    
//    public String ShowNamaSupplier(String idSupplier){
//        String nama = "";
//        con= new Koneksi();
//        try{
//            st = con.connect().createStatement();
//            res = st.executeQuery("SELECT *FROM tb_supplier WHERE idsupplier = '"+idSupplier+"'");
//            while(res.next()){
//                nama = res.getString("nama");
//            }
//        }catch(SQLException ex){
//            
//        }
//        return nama;
//    }
    
    public int ShowStok(String idBarang){
        int stok = 0;
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_barang WHERE idbarang = '"+idBarang+"'");
            while(res.next()){
                stok = res.getInt("stok");
            }
        }catch(SQLException ex){
            
        }
        
        
        return stok;
    }
}
