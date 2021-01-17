package com.example.personal_note.db;

public class DashBoard {
    String name;
    int count;

    public DashBoard(String name, int count){
        this.name = name;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
