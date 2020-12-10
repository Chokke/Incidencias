package com.example.fragment.model;

public class Incidencia {
    protected int id;
    protected String title;
    protected String prioritat;

    public Incidencia(int id, String title, String prioritat){
        this.id = id;
        this.title = title;
        this.prioritat = prioritat;
    }

    public int getId(){ return id;}

    public String getTitle(){
        return title;
    }

    public String getPrioritat(){
        return prioritat;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setPrioritat(String newPrioritat){
        this.prioritat = newPrioritat;

    }

}
