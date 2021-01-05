package com.example.personal_note.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    //tao co so du lieu
    private static final String DATABASE_NAME = "notePersonal.db";
    private static final String CATEGORY = "tbl_Category";
    private static final String PRIORITY = "tbl_Priority";
    private static final String STATUS = "tbl_Status";
    private static final String NOTE = "tbl_Note";
    private static final String USER = "tbl_User";

    DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //tao bang

        String tbl_category = "CREATE TABLE " + CATEGORY + "(id INTERGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, date TEXT)";
        String tbl_priority = "CREATE TABLE " + PRIORITY + "(id INTERGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, date TEXT)";
        String tbl_status = "CREATE TABLE " + STATUS + "(id INTERGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, date TEXT)";
        String tbl_note = "CREATE TABLE " + NOTE + "(id INTERGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, date TEXT,id_Category INTERGER, id_Status INTERGER, id_priority INTERGER ,FOREIGN KEY (id_Category) REFERENCES CARETGORY (id) ,FOREIGN KEY (id_Status) REFERENCES STATUS (id),FOREIGN KEY (id_Priority) REFERENCES PRIORIRY (id))";
        String tbl_user = "CREATE TABLE " + USER + "(id INTERGER PRIMARY KEY AUTOINCREMENT, userName TEXT NOT NULL,password TEXT, mail TEXT)";

        db.execSQL(tbl_category);
        db.execSQL(tbl_priority);
        db.execSQL(tbl_status);
        db.execSQL(tbl_note);
        db.execSQL(tbl_user);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xoa cac bang ton tai
        db.execSQL("DROP TABLE IF EXISTS " + CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + PRIORITY);
        db.execSQL("DROP TABLE IF EXISTS " + STATUS);
        db.execSQL("DROP TABLE IF EXISTS " + NOTE);
        db.execSQL("DROP TABLE IF EXISTS " + USER);

    }


    // method them
    public boolean insert(String category, String priority, String status, String note, String user) {
        //
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        //Them categoy
        ContentValues values_cat = new ContentValues();
        values_cat.put("category", category);
        sqLiteDatabase.insert(CATEGORY, null, values_cat);

        //Them trang thhai
        ContentValues values_sta = new ContentValues();
        values_sta.put("status", priority);
        sqLiteDatabase.insert(STATUS, null, values_sta);

        //Them do uu tien
        ContentValues values_pri = new ContentValues();
        values_pri.put("priority", priority);
        sqLiteDatabase.insert(PRIORITY, null, values_pri);

        //them note
        ContentValues values_note = new ContentValues();
        values_note.put("note", note);
        sqLiteDatabase.insert(NOTE, null, values_note);

        //Them user
        ContentValues values_user = new ContentValues();
        values_user.put("user", user);
        sqLiteDatabase.insert(USER, null, values_user);

        return true;

    }


    //Lay category
    public ArrayList getCategory() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + CATEGORY, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            arrayList.add(cursor.getString(cursor.getColumnIndex("category")));
            cursor.moveToNext();
        }
        return arrayList;
    }

    //Lay priority
    public ArrayList getPriority() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + PRIORITY, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            arrayList.add(cursor.getString(cursor.getColumnIndex("priority")));
            cursor.moveToNext();
        }
        return arrayList;
    }

    //Lay status
    public ArrayList getStatus() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + STATUS, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            arrayList.add(cursor.getString(cursor.getColumnIndex("status")));
            cursor.moveToNext();
        }
        return arrayList;
    }

    //Lay category
    public ArrayList getNote() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + NOTE, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            arrayList.add(cursor.getString(cursor.getColumnIndex("note")));
            cursor.moveToNext();
        }
        return arrayList;
    }
}
