package com.example.insert_data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class db_handler extends SQLiteOpenHelper
{
    public static final String DB_NAME="ROCKY";
    public static final int DB_VERSION=1;
    public static final String TABLE_NAME="STUDENT";
    public static final String  ID="id";
    public static final String NAME="name";
    public static final String AGE="age";
    public db_handler(Context context)
    {
        super(context,DB_NAME,null,DB_VERSION);

    }

public void add_data(String name,String age)
{
    SQLiteDatabase db=this.getWritableDatabase();
    ContentValues contentValues=new ContentValues();
    contentValues.put(NAME,name);
    contentValues.put(AGE,age);
    db.insert(TABLE_NAME,null,contentValues);

}

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String query="CREATE TABLE "+TABLE_NAME+"("+ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+"TEXT,"+AGE+"TEXT"+")";
   db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
