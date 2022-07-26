/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

/**
 *
 * @author clairelin
 */
public class Appointments {
    
    protected int id;
    protected String firstname;
    protected String lastname;
    protected String donorcentre;
    protected String time;
    protected String date;
    protected String phoneno;
    protected String email;
    protected String notes;
    protected String donstatus;
    protected String dontype;

    public Appointments(int id, String firstname, String lastname, String donorcentre, String time, String date, String phoneno, String email, String notes, String donstatus, String dontype) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.donorcentre = donorcentre;
        this.time = time;
        this.date = date;
        this.phoneno = phoneno;
        this.email = email;
        this.notes = notes;
        this.donstatus = donstatus;
        this.dontype = dontype;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDonorcentre(String donorcentre) {
        this.donorcentre = donorcentre;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDonstatus(String donstatus) {
        this.donstatus = donstatus;
    }

    public void setDontype(String dontype) {
        this.dontype = dontype;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDonorcentre() {
        return donorcentre;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public String getEmail() {
        return email;
    }

    public String getNotes() {
        return notes;
    }

    public String getDonstatus() {
        return donstatus;
    }

    public String getDontype() {
        return dontype;
    }
    
    
    
}
