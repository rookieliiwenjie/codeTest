package com.company.反射demo;

/**
 * @Author rookie.li
 * @create 2021/4/22
 */
public class SonDemo extends FatherDemo{

    private String sonName;

    private String sonAge;

    public String pulicSonName;

    @Override
    public String toString() {
        return "SonDemo{" +
                "sonName='" + sonName + '\'' +
                ", sonAge='" + sonAge + '\'' +
                ", pulicSonName='" + pulicSonName + '\'' +
                ", pulicName='" + pulicName + '\'' +
                '}';
    }

    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }

    public String getSonAge() {
        return sonAge;
    }

    public void setSonAge(String sonAge) {
        this.sonAge = sonAge;
    }

    public String getPulicSonName() {
        return pulicSonName;
    }

    public void setPulicSonName(String pulicSonName) {
        this.pulicSonName = pulicSonName;
    }
}
