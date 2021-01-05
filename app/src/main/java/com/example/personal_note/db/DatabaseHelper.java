package com.example.personal_note.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class DatabaseHelper {
    Context context;

    private String dbName = "note_personal.db";
//    private static final String CATEGORY = "tbl_Category";
//    private static final String PRIORITY = "tbl_Priority";
//    private static final String STATUS = "tbl_Status";
//    private static final String NOTE = "tbl_Note";
//    private static final String USER = "tbl_User";


    public DatabaseHelper(Context context) {
        this.context = context;
    }

    public SQLiteDatabase openDB() {
        return context.openOrCreateDatabase("note_personal.db", Context.MODE_PRIVATE, null);
    }

    public void closeDB(SQLiteDatabase db) {
        db.close();
    }


    public void createTable() {
        SQLiteDatabase db = openDB();
        //tao bang
        String category = "create table if not exists tbl_category(id integer PRIMARY KEY autoincrement,name text,date text);";
        String status = "create table if not exists tbl_status(id integer PRIMARY KEY autoincrement,name text,date text);";
        String priority = "create table if not exists tbl_priority(id integer PRIMARY KEY autoincrement,name text,date text);";
        String note = "create table if not exists tbl_note(id integer PRIMARY KEY autoincrement,name text,date text,id_User integer,id_Catagory integer,id_Status integer, id_priority integer ,FOREIGN KEY (id_Catagory) REFERENCES tbl_category (id) ,FOREIGN KEY (id_Status) REFERENCES tbl_status (id),FOREIGN KEY (id_priority) REFERENCES tbl_priority (id),FOREIGN KEY (id_User) REFERENCES tbl_user (id));";
        String user = "create table if not exists tbl_user(id integer PRIMARY KEY autoincrement,name text,email text, password text);";

        //        String tbl_priority = "CREATE TABLE " + PRIORITY + "(id INTERGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, date TEXT)";
//        String tbl_status = "CREATE TABLE " + STATUS + "(id INTERGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, date TEXT)";
//        String tbl_note = "CREATE TABLE " + NOTE + "(id INTERGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, date TEXT,id_Category INTERGER, id_Status INTERGER, id_priority INTERGER ,FOREIGN KEY (id_Category) REFERENCES CARETGORY (id) ,FOREIGN KEY (id_Status) REFERENCES STATUS (id),FOREIGN KEY (id_Priority) REFERENCES PRIORIRY (id))";
//        String tbl_user = "CREATE TABLE " + USER + "(id INTERGER PRIMARY KEY AUTOINCREMENT, userName TEXT NOT NULL,password TEXT, mail TEXT)";

        db.execSQL(category);
        db.execSQL(priority);
        db.execSQL(status);
        db.execSQL(user);
        db.execSQL(note);
        db.close();
    }


}
