/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

/**
 *
 * @author clairelin
 */
public class DonorCentre {
    
    protected int id;
    protected String name;
    protected String address;
    protected String phone;
    protected String dontype;

    public DonorCentre(int id, String name, String address, String phone, String dontype) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.dontype = dontype;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDontype(String dontype) {
        this.dontype = dontype;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getDontype() {
        return dontype;
    }

    
}
