package com.example.fooddeliveryapp.Domain;

public class Location {
    private int Id;
    private String Loc;
    public Location(){

    }

    public int getId() {
        return Id;
    }

    @Override
    public String toString(){
        return Loc;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setLoc(String loc) {
        Loc = loc;
    }

    public String getLoc() {
        return Loc;
    }
}
