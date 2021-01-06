package com.example.personal_note.db;

public class User {
    int idUser;

    public User(int idUser, String emailUser, String passwordUser) {
        this.idUser = idUser;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
    }

    String emailUser;
    String passwordUser;

    public User() {
    }

    public User(String emailUser, String passwordUser) {
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
    }



    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }






}
