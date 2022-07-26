/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author clairelin
 */
public class Database {
    final private String database= "jdbc:sqlite:DonorDatabase.db";
    
    public void setupDatabase() throws SQLException {
        //connection to database
        Connection conn = DriverManager.getConnection(database);
        Statement st = conn.createStatement();
        
        //create donor centre table with id, name, address, phone, donation type
        String createDonorCentreQuery = "CREATE TABLE IF NOT EXISTS donorcentre"
                                    + "("
                                    + "ID INTEGER PRIMARY KEY autoincrement, "
                                    + "NAME TEXT NOT NULL, "
                                    + "ADDRESS TEXT NOT NULL, "
                                    + "PHONE TEXT NOT NULL,"
                                    + "DONTYPE TEXT"
                                    + ");";
        st.execute(createDonorCentreQuery);
        
        //create appointment table with id, first name, last name, donor centre, time, date, phone number, email, notes, donation status
        String createAppointmentQuery = "CREATE TABLE IF NOT EXISTS appointment"
				+ "("
                                + "ID INTEGER PRIMARY KEY autoincrement, "
                                + "FIRSTNAME TEXT NOT NULL, "
				+ "LASTNAME TEXT NOT NULL, "
				+ "DONORCENTRE TEXT NOT NULL, "
                                + "TIME TEXT NOT NULL,"
				+ "DATE TEXT NOT NULL,"
                                + "PHONENO TEXT NOT NULL,"
                                + "EMAIL TEXT NOT NULL,"
                                + "NOTES TEXT NOT NULL,"
                                + "DONSTATUS TEXT NOT NULL,"
                                + "DONTYPE TEXT NOT NULL "
				+ ");";
        st.execute(createAppointmentQuery);
        
        //insert data into tables
        insertDonorCentre();
        insertAppointment();
        
        //close statement
        st.close();
	conn.close();
    }

    public void insertDonorCentre() throws SQLException {
        Connection conn = DriverManager.getConnection(database);
        Statement st = conn.createStatement();
        
        PreparedStatement pSt = conn.prepareStatement(
            "INSERT OR IGNORE INTO donorcentre (id, name, address, phone, dontype) VALUES (?,?,?,?,?)"
        );

        // Data to insert
        String[] name = {"Town Hall Donor Centre", "Chatswood Donor Centre", "The Shire Donor Centre"};
        String[] address = {"483 George St, Sydney NSW 2000", "62, LEVEL 1/436 Victoria Ave, Chatswood NSW 2067", "29 Kiora Rd, Miranda NSW 2228"};
        String[] phone = {"13 14 95", "13 14 95", "13 14 95"};
        String[] dontype = {"Blood and Plasma", "Blood", "Blood and Plasma"};

        // Loop to insert using prepared statements
        for (int i = 0; i < 3; i++) {
            pSt.setInt(1, i);
            pSt.setString(2, name[i]);
            pSt.setString(3, address[i]);
            pSt.setString(4, phone[i]);
            pSt.setString(5, dontype[i]);
            pSt.executeUpdate();
        }
        
        st.close();
        conn.close();
        
    }

    public void insertAppointment() throws SQLException {
        Connection conn = DriverManager.getConnection(database);
        Statement st = conn.createStatement();
        
        PreparedStatement pSt = conn.prepareStatement(
            "INSERT OR IGNORE INTO appointment (id, firstname, lastname, donorcentre, time, date, phoneno, email, notes, donstatus, dontype) VALUES (?,?,?,?,?,?,?,?,?,?,?)"
        );

        // Data to insert
        String[] firstname = {"John", "Margret", "Jill"};
        String[] lastname = {"Pho", "Kip", "Dance"};
        String[] donorcentre = {"Town Hall Donor Centre", "Chatswood Donor Centre", "The Shire Donor Centre"};
        String[] time = {"12:08", "1:56", "2:34"};
        String[] date = {"03/07/22", "21/06/22", "30/05/22"};
        String[] phoneno = {"0465234987", "0412569276", "0417509469"};
        String[] email = {"johnpho@gmail.com", "margretkip@gmail.com", "jilldance@gmail.com"};
        String[] notes = {"Allergic to grass", "No allergies", "Allergic to peanuts"};
        String[] donstatus = {"Approved", "Approved", "Approved"};
        String[] dontype = {"Plasma", "Blood", "Blood"};

        // Loop to insert using prepared statements
        for (int i = 0; i < 3; i++) {
            pSt.setInt(1, i);
            pSt.setString(2, firstname[i]);
            pSt.setString(3, lastname[i]);
            pSt.setString(4, donorcentre[i]);
            pSt.setString(5, time[i]);
            pSt.setString(6, date[i]);
            pSt.setString(7, phoneno[i]);
            pSt.setString(8, email[i]);
            pSt.setString(9, notes[i]);
            pSt.setString(10, donstatus[i]);
            pSt.setString(11, dontype[i]);
            pSt.executeUpdate();
        }
        
        st.close();
        conn.close();
        
        
    }
    
    public ObservableList<DonorCentre> getCentre() throws SQLException {
        // Get ResultSet of all donor centres that exist in the database
        Connection conn = DriverManager.getConnection(database);
        Statement st = conn.createStatement();
        String query = "SELECT id, name, address, phone, dontype FROM donorcentre";
        ResultSet rs = st.executeQuery(query);
        
        ObservableList<DonorCentre> centreList = FXCollections.observableArrayList();
        // Add each row in the ResultSet to the petsList
        while (rs.next()) {
            centreList.add(new DonorCentre(rs.getInt("id"), rs.getString("name"), 
                rs.getString("address"), rs.getString("phone"), 
                rs.getString("dontype")));
        }
        
        // Close 
        st.close();
        conn.close();
        return centreList;
    }
    
    public ObservableList<Appointment> getAppointments() throws SQLException {
        // Get ResultSet of all appointments that exist in the database
        Connection conn = DriverManager.getConnection(database);
        Statement st = conn.createStatement();
        String query = "SELECT id, firstname, lastname, donorcentre, time, date, phoneno, email, notes, donstatus, dontype FROM appointment";
        ResultSet rs = st.executeQuery(query);
        
        ObservableList<Appointment> AppointmentsList = FXCollections.observableArrayList();
        // Add each row in the ResultSet to the petsList
        while (rs.next()) {
            AppointmentsList.add(new Appointment(rs.getInt("id"), rs.getString("firstname"), 
                rs.getString("lastname"), rs.getString("donorcentre"), rs.getString("time"),
                rs.getString("date"),rs.getString("phoneno"),rs.getString("email"),
                rs.getString("notes"),rs.getString("donstatus"),rs.getString("dontype")));
        }
        
        // Close 
        st.close();
        conn.close();
        return AppointmentsList;
    }
    

}

