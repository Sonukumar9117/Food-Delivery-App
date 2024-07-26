package com.example.fooddeliveryapp.Domain;

public class Price {
    private int Id;
    private String Value;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getValue() {
        return Value;
    }

    public Price(){

    }
    public String toString(){
        return Value;
    }
}
