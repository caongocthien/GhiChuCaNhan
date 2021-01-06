package com.example.personal_note.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
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
        String user = "create table if not exists tbl_user(id integer PRIMARY KEY autoincrement,email text, password text);";


        db.execSQL(category);
        db.execSQL(priority);
        db.execSQL(status);
        db.execSQL(user);
        db.execSQL(note);
        db.close();
    }

//Lay category
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



    //Lay priority
    public ArrayList getPriority()
    {
        SQLiteDatabase db=openDB();
        ArrayList<Priority> arrayList=new ArrayList<>();

        String sql="select * from tbl_priority";
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor!=null) {


            if (cursor.moveToNext()) {
                do {
                    String name = cursor.getString(1);
                    String date = cursor.getString(2);
                    arrayList.add(new Priority(name, date));
                }while (cursor.moveToNext());
            }
        }
        db.close();
        return  arrayList;
    }

    //Lay status
    public ArrayList getStatus()
    {
        SQLiteDatabase db=openDB();
        ArrayList<Status> arrayList=new ArrayList<>();

        String sql="select * from tbl_status";
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor!=null) {


            if (cursor.moveToNext()) {
                do {
                    String name = cursor.getString(1);
                    String date = cursor.getString(2);
                    arrayList.add(new Status(name, date));
                }while (cursor.moveToNext());
            }
        }
        db.close();
        return  arrayList;
    }
    //get user
    public ArrayList getUser()
    {
        SQLiteDatabase db=openDB();
        ArrayList<User> arrayList=new ArrayList<>();

        String sql="select * from tbl_user";
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor!=null) {


            if (cursor.moveToNext()) {
                do {
                    String email = cursor.getString(1);
                    String password = cursor.getString(2);
                    arrayList.add(new User(email,password));
                }while (cursor.moveToNext());
            }
        }
        db.close();
        return  arrayList;
    }





//Them category
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


    //Them Priority
    public long insertPriority(Priority pri)
    {
        SQLiteDatabase db = openDB();
        ContentValues priority =new ContentValues();
        priority.put("name",pri.getNamePriority());
        priority.put("date",pri.getDate());
        db.insert("tbl_priority",null, priority);
        long status = db.insert("tbl_priority",null,priority);
        db.close();
        return status;
    }

    //Them status

    public long insertStatus(Status sta)
    {
        SQLiteDatabase db = openDB();
        ContentValues status =new ContentValues();
        status.put("name",sta.getNameStatus());
        status.put("date",sta.getDate());
        db.insert("tbl_status",null, status);
        long status1 = db.insert("tbl_status",null,status);
        db.close();
        return status1;
    }

    //Xoa Category

//    public long deleteCategory(int id)
//    {
//        SQLiteDatabase db=openDB();
//        long status=db.delete("tbl_category","id="+id,null);
//        db.close();
//        return status;
//    }
    public void delete(Category category){
        SQLiteDatabase db=openDB();
        long status=db.delete("tbl_category", " id = " + category.getIdCategory(), null);
        if ( status> 0) {
            Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
        }
    }

    //Xoa Status

    public long deleteStatus(int id)
    {
        SQLiteDatabase db=openDB();
        long status=db.delete("tbl_status","id="+id,null);
        db.close();
        return status;
    }

    //Xoa Priority

    public long deletePriority(int id)
    {
        SQLiteDatabase db=openDB();
        long status=db.delete("tbl_Priority","id="+id,null);
        db.close();
        return status;
    }

    //them user
    public long insertUser(User uesr)
    {
        SQLiteDatabase db = openDB();
        ContentValues user =new ContentValues();
        user.put("email",uesr.getEmailUser());
        user.put("password",uesr.getPasswordUser());
        db.insert("tbl_user",null, user);
        long adduser = db.insert("tbl_user",null,user);
        db.close();
        return adduser;
    }

    //Update Category
//    public long updateCategory(int id,Category newCate)
//    {
//        ContentValues categori=new ContentValues();
//        categori.put("name",newCate.getNameCategory());
//        categori.put("date",newCate.getDate());
//        SQLiteDatabase db=openDB();
//        long status=db.update("tbl_category",categori,"id=?",new String[]{String.valueOf(id)});
//        db.close();
//        return status;
//    }
    public void updateCategory(Category category){
        SQLiteDatabase db=openDB();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name",category.getNameCategory());
    }

    //Update Status
    public long updateStatus(int id,Status newSta)
    {
        ContentValues status =new ContentValues();
        status.put("name",newSta.getNameStatus());
        status.put("date",newSta.getDate());
        SQLiteDatabase db=openDB();
        long status1=db.update("tbl_status",status,"id=?",new String[]{String.valueOf(id)});
        db.close();
        return status1;
    }

    //Update Status
    public long updatePriority(int id,Priority newPri)
    {
        ContentValues priority =new ContentValues();
        priority.put("name",newPri.getNamePriority());
        priority.put("date",newPri.getDate());
        SQLiteDatabase db=openDB();
        long status =db.update("tbl_priority",priority,"id=?",new String[]{String.valueOf(id)});
        db.close();
        return status;
    }


    //get Note





    //check mail ton tai
    public Boolean chkemail(String email){
        SQLiteDatabase db = openDB();
        String sqlemail="select * from tbl_user where email=?";
        Cursor cursor=db.rawQuery(sqlemail,new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }

    //kiem tra dng nhap
    public Boolean emailpassword(String email, String password){
        SQLiteDatabase db = openDB();
        String sqlcheck="select * from tbl_user where email=? and password=?";
        Cursor cursor=db.rawQuery(sqlcheck,new String[]{email,password});
        if(cursor.getCount()>0) return true;
        else return false;

    }
}
