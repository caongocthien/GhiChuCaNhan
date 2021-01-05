package com.example.personal_note.db;

public class Priority {
    int idPriority;
    String namePriority;
    String date;

    public Priority(String namePriority, String date) {
        this.namePriority = namePriority;
        this.date = date;
    }



    public Priority() {
    }



    public Priority(int idPriority, String namePriority, String date) {
        this.idPriority = idPriority;
        this.namePriority = namePriority;
        this.date = date;
    }



    public int getIdPriority() {
        return idPriority;
    }

    public void setIdPriority(int idPriority) {
        this.idPriority = idPriority;
    }

    public String getNamePriority() {
        return namePriority;
    }

    public void setNamePriority(String namePriority) {
        this.namePriority = namePriority;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
