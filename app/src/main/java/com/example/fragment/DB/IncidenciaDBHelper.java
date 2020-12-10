package com.example.fragment.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.fragment.DB.IncidenciaContract.*;
import com.example.fragment.model.Incidencia;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import static com.example.fragment.DB.IncidenciaContract.IncidenciaEntry.COLUMN_NAME_TITLE;
import static com.example.fragment.DB.IncidenciaContract.IncidenciaEntry.COLUMN_NAME_TITLE2;
import static com.example.fragment.DB.IncidenciaContract.IncidenciaEntry.TABLE_NAME;

public class IncidenciaDBHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "incidencies.db";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + IncidenciaEntry.TABLE_NAME + "("
            + IncidenciaEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            IncidenciaEntry.COLUMN_NAME_TITLE + " TEXT," + IncidenciaEntry.COLUMN_NAME_TITLE2 + " TEXT)";



    public IncidenciaDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertIncidencia(SQLiteDatabase db, Incidencia i){
        //Check the bd is open
        if (db.isOpen()){
//Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the incidence getting all values
            values.put(COLUMN_NAME_TITLE, i.getTitle());
            values.put(COLUMN_NAME_TITLE2, i.getPrioritat());

            db.insert(TABLE_NAME, null, values);
        }else{
            Log.d("sql","Database is closed");
        }
    }

    public static ArrayList<Incidencia> getAllIssues(SQLiteDatabase db){
        Cursor cursor = db.rawQuery("SELECT * FROM " + IncidenciaEntry.TABLE_NAME, null);
        ArrayList<Incidencia> issueArrayList = new ArrayList<>();
        Incidencia issue;
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                issue = new Incidencia(cursor.getInt(cursor.getColumnIndex(IncidenciaEntry.ID)),
                        cursor.getString(cursor.getColumnIndex(IncidenciaEntry.COLUMN_NAME_TITLE)),
                        cursor.getString(cursor.getColumnIndex(IncidenciaEntry.COLUMN_NAME_TITLE2))
                        );
                issueArrayList.add(issue);
            } while(cursor.moveToNext());
        }
        cursor.close();
        return issueArrayList;
    }

    public void dropTable(SQLiteDatabase db){
        db.execSQL("DROP TABLE "+ IncidenciaEntry.TABLE_NAME);
    }

}
