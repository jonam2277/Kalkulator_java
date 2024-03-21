/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator.main;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

//import java.sql.DriverManager;
//import static kalkulator.main.KalkulatorFom.pembagian;
//import static kalkulator.main.KalkulatorFom.pengurangan;
//import static kalkulator.main.KalkulatorFom.penjumlahan;
//import static kalkulator.main.KalkulatorFom.perkalian;


public class classAPP {
    public static void main(String[] args) {
        KalkulatorFom kf = new KalkulatorFom();
        kf.setLocationRelativeTo(null);
        kf.setVisible(true);
    }
    
    public static Double hitung(Double angka1, Double angka2, String operator){
        Double hasil = null;
 
         if (operator.equals("+")) {
            hasil = penjumlahan(angka1, angka2);
        } else if (operator.equals("-")) {
             hasil = pengurangan(angka1, angka2);
        } else if (operator.equals("/")) {
             hasil = pembagian(angka1, angka2);
        } else if (operator.equals("*")){
             hasil = perkalian(angka1, angka2);
        }
         return hasil;
    }
    
    public static Double penjumlahan(double angka1, double angka2) {
        double hasil = angka1 + angka2;
        return hasil;
    }
    
    public static Double pengurangan(double angka1, double angka2) {
        double hasil = angka1 + angka2;
        return hasil;
    }
    
    public static Double pembagian(double angka1, double angka2) {
        double hasil = angka1 + angka2;
        return hasil;
    }
    
    public static Double perkalian(double angka1, double angka2) {
        double hasil = angka1 + angka2;
        return hasil;
    }
    
    public static void hitung(Double angka1, Double angka2, String operator, Double hasil){
    Connection connect;
    PreparedStatement pst;
    
    String url = "jdbc:mysql://localhost:3306/kalkulator_dul";
    String username = "root";
    String password = "";
    String query = "INSERT INTO hitung (angka1, angka2, operator, hasil) values(?,?,?,?)";
    
    try {
        connect = DriverManager.getConnection(url, username, password);
        pst = connect.prepareStatement(query);
        pst.setDouble(1, angka1);
        pst.setDouble(2, angka2);
        pst.setString(3, operator);
        pst.setDouble(4, hasil);
        pst.executeUpdate();
        pst.close();
    } catch (SQLException ex){
        System.out.println("Insert gaga: " + ex);
    }
    }
}
