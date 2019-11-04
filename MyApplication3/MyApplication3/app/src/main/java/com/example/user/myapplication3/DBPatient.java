package com.example.user.myapplication3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ProgrammingKnowledge on 4/3/2015.
 */
public class DBPatient extends SQLiteOpenHelper {
    public static final String DATABASE_NAME2 = "patient.db";
    public static final String TABLE_NAME2 = "patient_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "USERNAME";
    public static final String COL_3 = "AGE";
    public static final String COL_4 = "BLOODGROUP";
    public static final String COL_5 = "PASSWORD";
    public static final String COL_6 = "TIMING";

    public DBPatient(Context context) {
        super(context, DATABASE_NAME2, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME2+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, AGE INTEGER, BLOODGROUP TEXT, PASSWORD TEXT, TIMING TEXT)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME2);
        onCreate(db);
    }

    public boolean insertData2(String username , int age, String bloodGroup, String password,String timing){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        int i = 120;
//        contentValues.put(COL_1, i++);
        contentValues.put(COL_2, username);
        contentValues.put(COL_3, age);
        contentValues.put(COL_4, bloodGroup);
        contentValues.put(COL_5, password);
        contentValues.put(COL_6, timing);
        long result = db.insert(TABLE_NAME2,null,contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }



    public Cursor getBasedOnDBName(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME2+" where USERNAME = '"+username+ "'", null);
        return res;
    }

//    public boolean updateData(String id,String name,String surname,String marks) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_1,id);
//        contentValues.put(COL_2,name);
//        contentValues.put(COL_3,surname);
//        contentValues.put(COL_4,marks);
//        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
//        return true;
//    }
//
//    public Integer deleteData (String id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
//    }
}
