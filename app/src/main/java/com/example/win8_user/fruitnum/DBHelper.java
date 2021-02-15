package com.example.win8_user.fruitnum;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by WIN8_USER on 2017/1/12.
 */

public class DBHelper extends SQLiteOpenHelper {
    private final static int _DBVersion = 1;
    private final static String _DBName = "SampleList.db";
    private final static String _TableName = "Player";
    //static String name="Player";
    //static SQLiteDatabase.CursorFactory factory=null;
    //static  int version=1;
    /*public DBHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }*/

    public DBHelper(Context context) {
        super(context, _DBName, null, _DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //String SQL="CREATE TABLE IF NOT EXISTS Player(PLAYER_NAME  TEXT  , COIN  INTEGER)";
        final String SQL = "CREATE TABLE IF NOT EXISTS " + _TableName + "( " +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "_PLAYERNAME VARCHAR(50), " +
                "_COIN TEXT " +
                ");";
        sqLiteDatabase.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String SQL="DROP TABLE IF EXISTS Player";
        sqLiteDatabase.execSQL(SQL);
        onCreate(sqLiteDatabase);
    }
}
