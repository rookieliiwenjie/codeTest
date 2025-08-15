package com.company.javaBase;

public class Address implements Cloneable{
    private String province;
    private String city;
    private String street;

    public Address(String province, String city, String street) {
        this.province = province;
        this.city = city;
        this.street = street;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        Address address = new Address("河南省", "郑州市", "金水区");
        try {
            Address address1 = (Address) address.clone();
            System.out.println(address == address1);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
