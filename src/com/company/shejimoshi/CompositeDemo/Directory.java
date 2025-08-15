package com.company.shejimoshi.CompositeDemo;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent {
    List<FileSystemComponent> files = new ArrayList<>();
    private String name;
    public void addComponent(FileSystemComponent file){
        files.add(file);
    }
    public Directory(String name) {
        this.name = name;
    }

    @Override
    public void displayInfo() {
        System.out.println("Directory:"+name);
        for (FileSystemComponent fileSystemComponent : files) {
            fileSystemComponent.displayInfo();
        }
    }
}
