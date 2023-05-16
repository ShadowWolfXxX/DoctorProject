/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class User {
    //لازم نفس اسماء بداتا بيز

    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String passwrod;
    private String age;
    private String phone;
    private String gender;
    private String role;

    public User(String username, String firstname, String lastname, String email, String passwrod, String age, String phone, String gender, String role) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.passwrod = passwrod;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int save() throws SQLException {
        Connection c = DB.getinstend().getConntectin();
        PreparedStatement ps = null;
        int counter = 0;
        String sql = "insert into users (username, passwrod, firstname, lastname, age, email, phone, gender, role) VALUES (?,?,?,?,?,?,?,?,?)";
        ps = c.prepareStatement(sql);
        ps.setString(1, this.getUsername());
        ps.setString(2, this.getPasswrod());
        ps.setString(3, this.getFirstname());
        ps.setString(4, this.getLastname());
        ps.setString(5, this.getAge());
        ps.setString(6, this.getEmail());
        ps.setString(7, this.getPhone());
        ps.setString(8, this.getGender());
        ps.setString(9, this.getRole());
        counter = ps.executeUpdate();

        if (ps != null) {
            ps.close();
        }
        c.close();
        return counter;
    }

    public static ArrayList<User> getAll() throws SQLException {
        Connection c = DB.getinstend().getConntectin();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users where role='patient'";
        ps = c.prepareCall(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            User user = new User(rs.getString(2), rs.getString(4),
                    rs.getString(5), rs.getString(7), rs.getString(3),
                    rs.getString(6), rs.getString(8), rs.getString(9), rs.getString(10));
            user.setId(rs.getInt(1));
            users.add(user);
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return users;
    }
    
      public static ArrayList<User> getAllForAdmin() throws SQLException {
        Connection c = DB.getinstend().getConntectin();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users where role='Admin'";
        ps = c.prepareCall(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            User user = new User(rs.getString(2), rs.getString(4),
                    rs.getString(5), rs.getString(7), rs.getString(3),
                    rs.getString(6), rs.getString(8), rs.getString(9), rs.getString(10));
            user.setId(rs.getInt(1));
            users.add(user);
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return users;
    }
    
     public static ArrayList<User> search(String word) throws SQLException {
        Connection c = DB.getinstend().getConntectin();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users where firstname='" + word + "' and role='patient'";
        ps = c.prepareCall(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            User user = new User(rs.getString(2), rs.getString(4),
                    rs.getString(5), rs.getString(7), rs.getString(3),
                    rs.getString(6), rs.getString(8), rs.getString(9), rs.getString(10));
            user.setId(rs.getInt(1));
            users.add(user);
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return users;
    }

    public int update() throws SQLException {
        Connection c = DB.getinstend().getConntectin();
        PreparedStatement ps = null;
        int counter = 0;
        String sql = "Update users set username=?,passwrod=?,firstname=?,lastname=?,age=?,email=?,phone=?,gender=?,role=? where id=?";
        ps = c.prepareStatement(sql);
        ps.setString(1, this.getUsername());
        ps.setString(2, this.getPasswrod());
        ps.setString(3, this.getFirstname());
        ps.setString(4, this.getLastname());
        ps.setString(5, this.getAge());
        ps.setString(6, this.getEmail());
        ps.setString(7, this.getPhone());
        ps.setString(8, this.getGender());
        ps.setString(9, this.getRole());
        ps.setInt(10, this.getId());
        counter = ps.executeUpdate();

        if (ps != null) {
            ps.close();
        }
        c.close();
        return counter;
    }
    
    //delete?

}
