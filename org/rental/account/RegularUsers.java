package org.rental.account;

public class RegularUsers extends Users {
    private String address;
    private String contactNumber;
    private String orderInformation;
    
    public RegularUsers(String userName, String userPassword) {
        super(userName, userPassword);
    }
    public RegularUsers() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getOrderInformation() {
        return orderInformation;
    }

    public void setOrderInformation(String orderInformation) {
        this.orderInformation = orderInformation;
    }
    
}
