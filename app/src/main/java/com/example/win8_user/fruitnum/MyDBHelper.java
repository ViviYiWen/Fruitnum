package com.example.win8_user.fruitnum;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by WIN8_USER on 2017/1/12.
 */

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Player";
    private static final int DB_VERSION = 1;
    //static String name="Player";
    //static SQLiteDatabase.CursorFactory factory=null;
    static  int version=1;

    public MyDBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    public MyDBHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //String SQL="CREATE TABLE IF NOT EXISTS Player(玩家 Text PRIMARY KEY,金幣數 INTEGER)";
        String SQL="CREATE TABLE IF NOT EXISTS Player (PLAYER_NAME TEXT, COIN  INTEGER)";
        sqLiteDatabase.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String SQL="DROP TABLE IF EXISTS Player";
        sqLiteDatabase.execSQL(SQL);
        onCreate(sqLiteDatabase);
    }
}

