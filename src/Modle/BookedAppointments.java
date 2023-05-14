/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author HP
 */
public class BookedAppointments {
   
    private int id;
    private int appointment_id ;
    private int user_id ;
    private String status;
    private String doctor_commnet;

    public BookedAppointments(int appointment_id, int user_id, String status, String doctor_commnet) {
        this.appointment_id = appointment_id;
        this.user_id = user_id;
        this.status = status;
        this.doctor_commnet = doctor_commnet;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDoctor_commnet() {
        return doctor_commnet;
    }

    public void setDoctor_commnet(String doctor_commnet) {
        this.doctor_commnet = doctor_commnet;
    }
    
    
    public int save() throws SQLException{
        Connection c = DB.getinstend().getConntectin();
        PreparedStatement ps = null;
        int counter = 0;
                String sql = "INSERT INTO booked_appointments (appointment_id, user_id, status, doctor_commnet) VALUES (?,?,?,?)";
                ps = c.prepareStatement(sql);
                ps.setInt(1, this.getAppointment_id());
                ps.setInt(2, this.getUser_id());
                ps.setString(3, this.getStatus());
                ps.setString(4, this.getDoctor_commnet());
                counter = ps.executeUpdate();
                if(counter>0){
                    //succes
                }
                if(ps != null){
                 ps.close();
                }
                c.close();
                return counter;      
    }
    
    public static ArrayList<BookedAppointments> getAll() throws SQLException{
     Connection c = DB.getinstend().getConntectin();   
     PreparedStatement ps = null;
     ResultSet rs = null;
     ArrayList<BookedAppointments> bookedP = new ArrayList<>();
     String sql = "SELECT * FROM booked_appointments";
     ps= c.prepareCall(sql);
     rs = ps.executeQuery();
        while (rs.next()) {
            BookedAppointments bp = new BookedAppointments(rs.getInt(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5));
            bp.setId(rs.getInt(1));
            bookedP.add(bp);
        }
        if(ps != null){
            ps.close();
        }
        c.close();
     return bookedP;
    }
    
}
