package com.example.personal_note.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


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


        db.execSQL(category);
        db.execSQL(priority);
        db.execSQL(status);
        db.execSQL(user);
        db.execSQL(note);
        db.close();
    }


    public ArrayList getCategory()
    {
        SQLiteDatabase db=openDB();
        ArrayList<Category> arrayList=new ArrayList<>();

        String sql="select * from tbl_category";
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor!=null) {


            if (cursor.moveToNext()) {
                do {
                    String name = cursor.getString(1);
                    String date = cursor.getString(2);
                    arrayList.add(new Category(name, date));
                }while (cursor.moveToNext());
            }
        }
        db.close();
        return  arrayList;
    }


    public long insertCategory(Category cate)
    {
        SQLiteDatabase db = openDB();
        ContentValues category =new ContentValues();
        category.put("name",cate.getNameCategory());
        category.put("date",cate.getDate());
        db.insert("tbl_category",null, category);
       long status = db.insert("tbl_category",null,category);
        db.close();
        return status;
    }




}
