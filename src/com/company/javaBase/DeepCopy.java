package com.company.javaBase;



/**
 * 引用拷贝
 * 浅拷贝 与 深拷贝
 * 浅拷贝  对于内部属性是引用类型的，那么拷贝的是引用，两个对象的引用指向同一个对象
 * 深拷贝  对于内部属性是引用类型的，那么拷贝的是引用指向的对象，两个对象的引用指向不同的对象
 */
public class DeepCopy implements Cloneable {
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        DeepCopy deepCopy = new DeepCopy();
        DeepCopy deepCopy1 = null;
        Address address1 = new Address("河南省", "郑州市", "金水区");
        deepCopy.setAddress(address1);
        try {
            deepCopy1 = (DeepCopy) deepCopy.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(deepCopy == deepCopy1);
        System.out.println(deepCopy.getAddress() == deepCopy1.getAddress());
    }

}
