package com.example.personal_note.db;

public class User {
    int idUser;

    public User(int idUser, String emailUser, String passwordUser, String firstnameUser, String lastnameUser ) {
        this.idUser = idUser;

        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
        this.firstnameUser = firstnameUser;
        this.lastnameUser = lastnameUser;

    }

    String emailUser;
    String passwordUser;
    String firstnameUser;
    String lastnameUser;

    public User() {
    }

    public User(String emailUser, String passwordUser, String firstnameUser, String lastnameUser) {
        this.firstnameUser = firstnameUser;
        this.lastnameUser = lastnameUser;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
    }



    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public String getFirstnameUser() {return firstnameUser;}
    public void setFirstnameUser(String firstnameUser){this.firstnameUser = firstnameUser;}

    public String getLastnameUser(){return lastnameUser;}
    public void setLastnameUser(String lastnameUser){this.lastnameUser = lastnameUser;}

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
