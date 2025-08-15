package com.company.shejimoshi.CompositeDemo;
//复合组件
public class File implements FileSystemComponent {

    private String name;

    public File(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void displayInfo() {
        System.out.println("file:" + name);
    }
}
