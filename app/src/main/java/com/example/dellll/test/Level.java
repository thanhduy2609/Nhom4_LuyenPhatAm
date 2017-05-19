package com.example.dellll.test;

/**
 * Created by DELLLL on 5/5/2017.
 */
public class Level {

    private String Name;
    private String Number;
    private String Status;

    public Level(String name, String number, String status) {
        Name = name;
        Number = number;
        Status = status;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
