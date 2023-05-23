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
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Appointment {

    private int id;
    private Date appointment_date;
    private String appointment_day;
    private Time appointment_time;
    private String status;

    public Appointment(Date appointment_date, String appointment_day, Time appointment_time, String status) {
        this.appointment_date = appointment_date;
        this.appointment_day = appointment_day;
        this.appointment_time = appointment_time;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAppointment_day() {
        return appointment_day;
    }

    public void setAppointment_day(String appointment_day) {
        this.appointment_day = appointment_day;
    }

    public Time getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(Time appointment_time) {
        this.appointment_time = appointment_time;
    }

    public Date getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(Date appointment_date) {
        this.appointment_date = appointment_date;
    }

    //add appointment
    public int save() throws SQLException {
        Connection c = DB.getinstend().getConntectin();
        PreparedStatement ps = null;
        int counter = 0;
        String sql = "INSERT INTO appointment(appointment_date, appointment_day, appointment_time, status) VALUES (?,?,?,?)";
        ps = c.prepareStatement(sql);
        ps.setDate(1, this.getAppointment_date());
        ps.setString(2, this.getAppointment_day());
        ps.setTime(3, this.getAppointment_time());
        ps.setString(4, "free");
        counter = ps.executeUpdate();
        if (counter > 0) {
            //succes
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return counter;
    }

    //get all apointment
    public static ArrayList<Appointment> getAll() throws SQLException {
        Connection c = DB.getinstend().getConntectin();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointment";
        ps = c.prepareCall(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Appointment app = new Appointment(rs.getDate(2), rs.getString(3), rs.getTime(4), rs.getString(5));
            app.setId(rs.getInt(1));
            appointments.add(app);
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return appointments;
    }
    
    
    //upadte appointmet
    public int update() throws SQLException {
        Connection c = DB.getinstend().getConntectin();
        PreparedStatement ps = null;
        int counter = 0;
        String sql = "Update appointment set appointment_date=?,appointment_day=?,appointment_time=?,status=? where id=?";
        ps = c.prepareStatement(sql);
        ps.setDate(1, this.getAppointment_date());
        ps.setString(2, this.getAppointment_day());
        ps.setTime(3, this.getAppointment_time());
        ps.setString(4, this.getStatus());
        ps.setInt(5, this.getId());
        counter = ps.executeUpdate();

        if (ps != null) {
            ps.close();
        }
        c.close();
        return counter;
    }

    
    //delete appointemt
    public int delete() throws SQLException, ClassNotFoundException {
        Connection c = DB.getinstend().getConntectin();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "DELETE FROM appointment WHERE ID=? ";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getId());
        recordCounter = ps.executeUpdate();

        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordCounter;
    }

}
